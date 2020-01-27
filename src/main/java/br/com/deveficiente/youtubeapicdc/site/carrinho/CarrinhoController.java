package br.com.deveficiente.youtubeapicdc.site.carrinho;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;
import br.com.deveficiente.youtubeapicdc.detalhelivro.LivroRepository;
import br.com.deveficiente.youtubeapicdc.shared.Cookies;
import br.com.deveficiente.youtubeapicdc.site.detalhe.Carrinho;

@RestController
public class CarrinhoController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private Cookies cookies;

	@PostMapping(value = "/api/carrinho/{idLivro}/atualiza")
	public void atualiza(@PathVariable("idLivro") Long idLivro ,@RequestParam int novaQuantidade,@CookieValue("carrinho") String jsonCarrinho,HttpServletResponse response) {
		Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
		Livro livro = livroRepository.findById(idLivro).get();
		
		carrinho.atualiza(livro,novaQuantidade);
		cookies.writeAsJson("carrinho", carrinho, response);
		
		
		
	}

}
