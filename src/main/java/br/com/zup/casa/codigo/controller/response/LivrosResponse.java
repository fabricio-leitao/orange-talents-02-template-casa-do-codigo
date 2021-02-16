package br.com.zup.casa.codigo.controller.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casa.codigo.model.Livro;

public class LivrosResponse {

	private Long id;
	private String titulo;
	public LivrosResponse(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
	}
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public static List<LivrosResponse> converter(List<Livro> list) {
		return list.stream().map(LivrosResponse::new).collect(Collectors.toList());
	}
	
	
}
