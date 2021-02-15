package br.com.zup.casa.codigo.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.casa.codigo.annotation.UniqueValue;
import br.com.zup.casa.codigo.model.Categoria;

public class NovaCategoriaResquest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName="nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}
