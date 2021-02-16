package br.com.zup.casa.codigo.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casa.codigo.controller.request.NovoClienteRequest;

public class VerificaCpfOuCnpjValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovoClienteRequest request = (NovoClienteRequest) target;
		
		if(!request.documentoValido()) {
			errors.rejectValue("cpfOuCnpj", null, "precisa digitar cpf ou cnpj");
		}
		
	}

}
