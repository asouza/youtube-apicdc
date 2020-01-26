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
import br.com.deveficiente.youtubeapicdc.shared.Cookies;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private Cookies cookies;

	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO exibeDetalhes(@PathVariable("id") Long id) {
		
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}
	
	@PostMapping(value = "/api/carrinho/{idLivro}")
	public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro,@CookieValue("carrinho") Optional<String> jsonCarrinho,HttpServletResponse response) throws JsonProcessingException {
		Carrinho carrinho = Carrinho.cria(jsonCarrinho);
		
		carrinho.adiciona(livroRepository.findById(idLivro).get());
		
		cookies.writeAsJson("carrinho",carrinho,response);
		
		return carrinho.toString();
	}


}
