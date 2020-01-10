package br.com.deveficiente.youtubeapicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{
}
