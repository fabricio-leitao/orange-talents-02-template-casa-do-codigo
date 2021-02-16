package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.response.DetalhesLivroResponse;
import br.com.zup.casa.codigo.model.Livro;

@RestController
public class DetalhesLivroController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping(value = "/produtos/{id}")
	public ResponseEntity<DetalhesLivroResponse> detalhar(@PathVariable("id") Long id) {

		Livro buscaLivro = manager.find(Livro.class, id);
		if (buscaLivro == null) {
			return ResponseEntity.notFound().build();
		}
		DetalhesLivroResponse detalhesLivroResponse = new DetalhesLivroResponse(buscaLivro);
		return ResponseEntity.ok(detalhesLivroResponse);

	}
}
