package br.com.deveficiente.youtubeapicdc.site;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.youtubeapicdc.detalhelivro.LivroRepository;

@RestController
public class HomeController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/home")
	public Collection<LivroParaHomeDTO> lista() {
		return livroRepository.findAll().stream()
				.map(LivroParaHomeDTO::new)
				.collect(Collectors.toList());
	}

}
