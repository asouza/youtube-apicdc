package br.com.deveficiente.youtubeapicdc.site.detalhe;

import java.math.BigDecimal;

import br.com.deveficiente.youtubeapicdc.detalhelivro.Livro;
import br.com.deveficiente.youtubeapicdc.shared.configuration.Markdown;

public class LivroDetalheDTO {

	private String titulo;
	private String subTitulo;
	private BigDecimal preco;
	private String conteudo;
	private String sumarioOriginal;
	private int numeroPaginas;
	private String isbn;
	private AutorLivroDetalheDTO autor;
	private Long id;
	private String sumarioHtml;

	public LivroDetalheDTO(Livro livro) {
		titulo = livro.getTitulo();
		subTitulo = livro.getSubTitulo();
		preco = livro.getPreco();
		conteudo = livro.getConteudo();
		sumarioOriginal = livro.getSumario();
		sumarioHtml = Markdown.renderHtml(livro.getSumario());
		autor = new AutorLivroDetalheDTO(livro.getAutor());
		numeroPaginas = livro.getNumeroPaginas();
		isbn = livro.getIsbn();
		id = livro.getId();

	}
	
	public String getSumarioHtml() {
		return sumarioHtml;
	}
	
	public Long getId() {
		return id;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getSumarioOriginal() {
		return sumarioOriginal;
	}

	public void setSumarioOriginal(String sumario) {
		this.sumarioOriginal = sumario;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public AutorLivroDetalheDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorLivroDetalheDTO autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
}
