package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
