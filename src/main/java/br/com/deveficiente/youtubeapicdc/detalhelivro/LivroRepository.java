package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findByIsbn(String isbn);

	Optional<Livro> findByTitulo(String titulo);
	
	@Override
	Collection<Livro> findAll();

}
