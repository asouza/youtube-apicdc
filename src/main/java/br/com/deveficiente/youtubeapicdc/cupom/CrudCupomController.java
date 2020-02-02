package br.com.deveficiente.youtubeapicdc.cupom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudCupomController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping(value = "/api/cupom")
	@Transactional
	public String cria(@RequestBody @Valid NovoCupomForm form) {
		
		Cupom cupom = form.novoCupom();
		manager.persist(cupom);
		
		return "criado";
	}

}
