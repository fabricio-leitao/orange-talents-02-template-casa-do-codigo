package br.com.zup.casa.codigo.controller.response;

import br.com.zup.casa.codigo.model.Autor;

public class DetalheSiteAutorResponse {

	private String nome;
	private String descricao;

	public DetalheSiteAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
