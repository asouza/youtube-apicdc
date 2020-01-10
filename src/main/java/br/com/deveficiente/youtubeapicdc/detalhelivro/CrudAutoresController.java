package br.com.deveficiente.youtubeapicdc.detalhelivro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudAutoresController {
	
	@Autowired
	private AutorRepository autorRepository;;

	@PostMapping(value = "/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
	}

}
