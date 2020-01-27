package br.com.deveficiente.youtubeapicdc.site.detalhe;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrinho {

	private Set<LivroCarrinhoDTO> livros = new LinkedHashSet<>();

	@Deprecated
	public Carrinho() {
		// TODO Auto-generated constructor stub
	}

	public void adiciona(Livro livro) {
		LivroCarrinhoDTO novoItem = new LivroCarrinhoDTO(livro);
		boolean result = livros.add(novoItem);
		if (!result) {
			LivroCarrinhoDTO itemExistente = livros.stream().filter(novoItem::equals).findFirst().get();
			itemExistente.incrementa();
		}
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

	public Set<LivroCarrinhoDTO> getLivros() {
		return livros;
	}

	/**
	 * 
	 * @param jsonCarrinho possível json de um carrinho já criado
	 * @return
	 */
	public static Carrinho cria(Optional<String> jsonCarrinho) {
		return jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
	}

	public void atualiza(@NotNull Livro livro, @Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0, "A quantidade de atualização tem que ser maior do que zero");

		LivroCarrinhoDTO possivelItemAdicionado = new LivroCarrinhoDTO(livro);
		Optional<LivroCarrinhoDTO> possivelItem = livros.stream().filter(possivelItemAdicionado::equals).findFirst();

		Assert.isTrue(possivelItem.isPresent(), "Você não deveria atualizar um livro que não foi colocado no carrinho");

		LivroCarrinhoDTO itemQueExiste = possivelItem.get();
		itemQueExiste.atualizaQuantidade(novaQuantidade);

	}

	public BigDecimal getTotal() {
		return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO,
				(atual, proximo) -> atual.add(proximo));
	}

}
