package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IsbnUnicoValidator implements Validator {

	private LivroRepository livroRepository;

	public IsbnUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		String isbn = form.getIsbn();
		
		Optional<Livro> possivelLivro = livroRepository.findByIsbn(isbn);
		if(possivelLivro.isPresent()) {
			errors.rejectValue("isbn", null,"Já existe um livro com esse isbn");
		}
	}

}
