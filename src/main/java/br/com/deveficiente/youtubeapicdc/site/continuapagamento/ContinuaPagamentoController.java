package br.com.deveficiente.youtubeapicdc.site.continuapagamento;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.youtubeapicdc.cupom.CupomRepository;
import br.com.deveficiente.youtubeapicdc.detalhelivro.LivroRepository;
import br.com.deveficiente.youtubeapicdc.site.detalhe.Carrinho;

@RestController
public class ContinuaPagamentoController {

	@Autowired
	private LivroRepository livroRepository;
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private CupomRepository cupomRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new CupomExistenteENaoExpiradoValidator(cupomRepository));
	}

	@PostMapping(value = "/api/carrinho/finaliza")
	@Transactional
	public String processa(@Valid DadosCompradorForm form,@CookieValue("carrinho") String jsonCarrinho) {
		Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
		
		Set<ItemCompra> itens =  carrinho.geraItensCompra(livroRepository);
		
		Compra novaCompra = form.novaCompra(itens,cupomRepository);
		
		manager.persist(novaCompra);
		
		return novaCompra.toString();
	}

}
