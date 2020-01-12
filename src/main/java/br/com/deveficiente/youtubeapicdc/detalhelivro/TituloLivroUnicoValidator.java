package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TituloLivroUnicoValidator implements Validator {

	private LivroRepository livroRepository;

	public TituloLivroUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		String titulo = form.getTitulo();
		
		Optional<Livro> possivelLivro = livroRepository.findByTitulo(titulo);
		if(possivelLivro.isPresent()) {
			errors.rejectValue("titulo", null,"Já existe um livro com esse titulo");
		}
	}

}
