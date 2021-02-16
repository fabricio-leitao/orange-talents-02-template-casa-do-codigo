package br.com.zup.casa.codigo.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.casa.codigo.annotation.UniqueValue;
import br.com.zup.casa.codigo.model.Pais;

public class NovoPaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
