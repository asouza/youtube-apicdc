package br.com.deveficiente.youtubeapicdc.site.detalhe;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;
	private int quantidade = 1;
	
	@Deprecated
	public LivroCarrinhoDTO() {
		// TODO Auto-generated constructor stub
	}

	public LivroCarrinhoDTO(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		linkCapaLivro = livro.getLinkCapaLivro();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public BigDecimal getTotal() {
		return preco.multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroCarrinhoDTO other = (LivroCarrinhoDTO) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public void incrementa() {
		this.quantidade++;
	}

	public void atualizaQuantidade(@Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0,"A quantidade de atualização tem que ser maior do que zero");
		
		this.quantidade = novaQuantidade;
	}
	
	
	

}
