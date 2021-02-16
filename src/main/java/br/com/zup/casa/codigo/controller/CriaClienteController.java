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

import br.com.zup.casa.codigo.controller.request.NovoClienteRequest;
import br.com.zup.casa.codigo.controller.validator.EstadoPertenceAPaisValidator;
import br.com.zup.casa.codigo.controller.validator.VerificaCpfOuCnpjValidator;
import br.com.zup.casa.codigo.model.Cliente;

@RestController
public class CriaClienteController {

	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
	
	@PersistenceContext
	private EntityManager manager;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaCpfOuCnpjValidator(), estadoPertenceAPaisValidator);
	}
	
	@PostMapping(value = "/clientes")
	@Transactional
	public String cria(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(manager);
		manager.persist(cliente);
		return cliente.toString();
	}
}
