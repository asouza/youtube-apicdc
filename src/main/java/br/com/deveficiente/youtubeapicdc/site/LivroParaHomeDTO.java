package br.com.deveficiente.youtubeapicdc.site;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;

public class LivroParaHomeDTO {

	private String titulo;
	private Long id;
	private String nomeAutor;

	public LivroParaHomeDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.id = livro.getId();
		this.nomeAutor = livro.getAutor().getNome();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

}
