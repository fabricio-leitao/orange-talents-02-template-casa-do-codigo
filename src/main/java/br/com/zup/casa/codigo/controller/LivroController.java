package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.request.NovoLivroRequest;
import br.com.zup.casa.codigo.model.Livro;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/livros")
	@Transactional
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		return livro.toString();
	}
	
}
