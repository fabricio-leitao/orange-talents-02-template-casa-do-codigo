package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.request.NovoPaisForm;
import br.com.zup.casa.codigo.model.Pais;

@RestController
public class PaisController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/paises")
	@Transactional
	public String cria(@RequestBody @Valid NovoPaisForm request) {
		Pais pais = new Pais(request.getNome());
		manager.persist(pais);
		return pais.toString();
	}
}
