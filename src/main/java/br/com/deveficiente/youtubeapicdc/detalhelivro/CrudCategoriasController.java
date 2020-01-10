package br.com.deveficiente.youtubeapicdc.detalhelivro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudCategoriasController {

	@Autowired
	private CategoryRepository categoriaRepository;
	
	
	@InitBinder("novaCategoriaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository));
	}

	@PostMapping(value = "/api/categoria")
	@Transactional
	public void nova(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		categoriaRepository.save(novaCategoria);
	}

}
