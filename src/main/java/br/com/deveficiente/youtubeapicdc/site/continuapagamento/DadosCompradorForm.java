package br.com.deveficiente.youtubeapicdc.site.continuapagamento;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.util.StringUtils;

import br.com.deveficiente.youtubeapicdc.cupom.Cupom;
import br.com.deveficiente.youtubeapicdc.cupom.CupomRepository;

public class DadosCompradorForm {

	@NotBlank
	@Email
	private String email;
	private String nome;

	@NotBlank
	@CpfCnpj
	private String documento;
	@NotBlank
	private String endereco;		
	private String complemento;	
	private String codigoCupom;
	
	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}
	
	public String getCodigoCupom() {
		return codigoCupom;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public Compra novaCompra(Set<ItemCompra> itens,CupomRepository cupomRepository) {
		Compra compra = new Compra(this.email,this.documento,this.endereco,itens);
		
		if(StringUtils.hasText(complemento)) {
			compra.setComplemento(complemento);
		}
		
		if(StringUtils.hasText(codigoCupom)) {
			compra.setCupom(cupomRepository.findByCodigo(codigoCupom).get());
		}
		return compra;
	}
	
	
	
}
