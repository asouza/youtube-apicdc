package br.com.deveficiente.youtubeapicdc.detalhelivro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String nome;

	@Deprecated
	public Categoria() {
	}
	
	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

}
