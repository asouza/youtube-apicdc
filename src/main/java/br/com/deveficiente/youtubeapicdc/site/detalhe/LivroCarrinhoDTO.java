package br.com.deveficiente.youtubeapicdc.site.detalhe;

import java.math.BigDecimal;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;

public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;
	
	@Deprecated
	public LivroCarrinhoDTO() {
		// TODO Auto-generated constructor stub
	}

	public LivroCarrinhoDTO(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		linkCapaLivro = livro.getLinkCapaLivro();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}
	
	

}
