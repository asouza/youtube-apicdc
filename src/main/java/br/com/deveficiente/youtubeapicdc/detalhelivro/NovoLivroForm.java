package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovoLivroForm {

	@NotBlank
	@Size(max = 100)
	private String titulo;
	@NotBlank
	@Size(max = 50)
	private String subTitulo;
	@Min(20)
	private BigDecimal preco;
	@NotBlank
	private String conteudo;
	@NotBlank
	private String sumario;
	@Min(100)	
	private int numeroPaginas;
	@NotBlank
	private String isbn;
	@NotNull
	private MultipartFile capa;
	@NotNull
	private Long autorId;
	
	
	
	public Long getAutorId() {
		return autorId;
	}
	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
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
	public MultipartFile getCapa() {
		return capa;
	}
	public void setCapa(MultipartFile capa) {
		this.capa = capa;
	}
	public Livro novoLivro(AutorRepository autorRepository,Uploader uploader) {
		Autor autor = autorRepository.findById(autorId).get();
		String linkCapaLivro = uploader.upload(capa);
		return new Livro(titulo,subTitulo,preco,conteudo,sumario,numeroPaginas,isbn,linkCapaLivro,autor);
	}
	
	
}
