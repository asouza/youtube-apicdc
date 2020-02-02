package br.com.deveficiente.youtubeapicdc.cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoCupomForm {

	@NotBlank
	private String codigo;
	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy kk:mm")
	@NotNull
	private LocalDateTime expiracao;
	@Positive
	@DecimalMax("0.25")
	private BigDecimal desconto;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(LocalDateTime expiracao) {
		this.expiracao = expiracao;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Cupom novoCupom() {
		return new Cupom(codigo,expiracao,desconto);
	}

}
