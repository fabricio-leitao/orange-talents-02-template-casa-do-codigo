package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.request.NovoEstadoForm;
import br.com.zup.casa.codigo.model.Estado;

@RestController
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/estados")
	@Transactional
	public String cria(@RequestBody @Valid NovoEstadoForm request) {
		Estado estado = request.toModel(manager);
		manager.persist(estado);
		return estado.toString();
	}
}
