package br.com.zup.casa.codigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.controller.response.LivrosResponse;
import br.com.zup.casa.codigo.model.Livro;
import br.com.zup.casa.codigo.repository.LivroRepository;

@RestController
public class ExibeLivrosController {
	
	//@PersistenceContext
	//private EntityManager manager;
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping(value = "/lista-livros")
	public List<LivrosResponse> exibir(){
		List<Livro> list= repository.findAll();
		
		return LivrosResponse.converter(list);
	}
	
	/*@GetMapping(value = "/lista-livros")
	@Transactional
	public List<LivrosResponse> exibir2(){
		List list= manager.createQuery("select l from livro l").getResultList();
		
		return LivrosResponse.converter(list);
	}*/
}
