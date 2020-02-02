package br.com.deveficiente.youtubeapicdc.site.continuapagamento;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		CPFValidator cpfValidator = new CPFValidator();
		//sei que posso tomar um NPE, mas daria muito trabalho validar na mão. Não gostou? Valide você. 
		cpfValidator.initialize(null);
		
		if(cpfValidator.isValid(value, context)) {
			return true;
		}		
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		if(cnpjValidator.isValid(value, context)) {
			return true;
		}
		
		return false;
	}

}
