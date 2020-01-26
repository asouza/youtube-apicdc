package br.com.deveficiente.youtubeapicdc.site.detalhe;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;
import br.com.deveficiente.youtubeapicdc.detalhelivro.LivroRepository;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO exibeDetalhes(@PathVariable("id") Long id) {
		
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}
	
	@PostMapping(value = "/api/carrinho/{idLivro}")
	public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro,@CookieValue("carrinho") Optional<String> jsonCarrinho,HttpServletResponse response) throws JsonProcessingException {
		Carrinho carrinho = jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
		
		carrinho.adiciona(livroRepository.findById(idLivro).get());
		
		Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
		cookie.setHttpOnly(true);
		
		response.addCookie(cookie);
		
		return carrinho.toString();
		/*
		 * receber o carrinho pelo cookie(json)
		 * se não tiver ainda cookie para o carrinho, então cria um novo carrinho
		 * preciso da capa, titulo, preco
		 */
	}


}
