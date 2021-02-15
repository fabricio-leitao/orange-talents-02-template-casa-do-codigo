package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.request.NovoAutorRequest;
import br.com.zup.casa.codigo.controller.validator.ProibeEmailDuplicadoAutorValidator;
import br.com.zup.casa.codigo.model.Autor;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	@PostMapping(value = "/autores")
	@Transactional
	public String cria(@Valid @RequestBody NovoAutorRequest request){
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
}
