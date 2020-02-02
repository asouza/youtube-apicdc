package br.com.deveficiente.youtubeapicdc.site.continuapagamento;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import br.com.deveficiente.youtubeapicdc.cupom.Cupom;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Email String email;
	@CpfCnpj
	private @NotBlank String documento;
	private @NotBlank String endereco;
	@ElementCollection
	private @Size(min = 1) Set<ItemCompra> itens = new HashSet<>();
	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now();
	private String complemento;
	@ManyToOne	
	private Cupom cupom;

	public Compra(@NotBlank @Email String email, @NotBlank String documento, @NotBlank String endereco,
			@Size(min = 1) Set<ItemCompra> itens) {
				this.email = email;
				this.documento = documento;
				this.endereco = endereco;
				this.itens.addAll(itens);
	}

	@Override
	public String toString() {
		return "Compra [email=" + email + ", documento=" + documento + ", endereco=" + endereco + ", itens=" + itens
				+ ", createdAt=" + createdAt + "]";
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
		
	}

	public void setCupom(Cupom cupom) {
		Assert.isTrue(cupom.taValido(),"Você passou um cupom inválido");
		this.cupom = cupom;
	}
	
	

}
