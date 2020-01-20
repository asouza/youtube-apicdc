package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Size(max = 100) String titulo;
	private @NotBlank @Size(max = 50) String subTitulo;
	private @Min(20) BigDecimal preco;
	private @NotBlank String conteudo;
	private @NotBlank String sumario;
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	private @NotBlank @URL String linkCapaLivro;
	@ManyToOne
	private @NotNull Autor autor;
	
	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 50) String subTitulo,
			@Min(20) BigDecimal preco, @NotBlank String conteudo, @NotBlank String sumario, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotBlank @URL String linkCapaLivro, @NotNull Autor autor) {
				this.titulo = titulo;
				this.subTitulo = subTitulo;
				this.preco = preco;
				this.conteudo = conteudo;
				this.sumario = sumario;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.linkCapaLivro = linkCapaLivro;
				this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", subTitulo=" + subTitulo + ", preco=" + preco + ", conteudo=" + conteudo
				+ ", sumario=" + sumario + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", linkCapaLivro="
				+ linkCapaLivro + ", autor=" + autor + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public String getSubTitulo() {
		return subTitulo;
	}
	
	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getSumario() {
		return sumario;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public String getIsbn() {
		return isbn;
	}
	

}
