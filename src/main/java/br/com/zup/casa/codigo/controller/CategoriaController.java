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

import br.com.zup.casa.codigo.controller.request.NovaCategoriaResquest;
import br.com.zup.casa.codigo.controller.validator.ProibeNomeDuplicadoValidator;
import br.com.zup.casa.codigo.model.Categoria;

@RestController
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ProibeNomeDuplicadoValidator proibeNomeDuplicadoValidator;

	@InitBinder
	private void init(WebDataBinder binder) {

		binder.addValidators(proibeNomeDuplicadoValidator);
	}

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@Valid @RequestBody NovaCategoriaResquest request) {
		Categoria categoria = new Categoria(request.getNome());
		manager.persist(categoria);
		return categoria.toString();
	}
}
