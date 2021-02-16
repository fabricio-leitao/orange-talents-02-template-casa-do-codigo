package br.com.zup.casa.codigo.controller.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casa.codigo.controller.request.NovoClienteRequest;
import br.com.zup.casa.codigo.model.Estado;
import br.com.zup.casa.codigo.model.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator{

	@PersistenceContext
	private EntityManager manager;
	
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
		
		if(request.temEstado()) {
			Pais pais = manager.find(Pais.class, request.getIdPais());
			Estado estado = manager.find(Estado.class, request.getIdEstado());
			if(!estado.pertenceAPais(pais)) {
				errors.rejectValue("idEstado", null, "este estado não é o do País selecionado");
			}
		}
	}

}
