package br.com.zup.casa.codigo.controller.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casa.codigo.controller.request.NovaCategoriaResquest;
import br.com.zup.casa.codigo.model.Categoria;
import br.com.zup.casa.codigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaResquest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		NovaCategoriaResquest request = (NovaCategoriaResquest)target;
		Optional<Categoria> possivelNome = categoriaRepository.findByNome(request.getNome());
		if (possivelNome.isPresent()) {
			errors.rejectValue("nome", null, "O nome desta categoria já existe " + request.getNome());
		}
	}

}
