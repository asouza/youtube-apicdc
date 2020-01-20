package br.com.deveficiente.youtubeapicdc.site.detalhe;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Autor;

public class AutorLivroDetalheDTO {

	private String nome;
	private String descricao;

	public AutorLivroDetalheDTO(Autor autor) {
		nome = autor.getNome();
		descricao = "Aqui precisa vir a descricao do autor";
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
