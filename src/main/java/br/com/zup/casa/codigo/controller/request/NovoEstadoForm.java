package br.com.zup.casa.codigo.controller.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.casa.codigo.annotation.ExistsId;
import br.com.zup.casa.codigo.annotation.UniqueValue;
import br.com.zup.casa.codigo.model.Estado;
import br.com.zup.casa.codigo.model.Pais;

public class NovoEstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public NovoEstadoForm(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		
		Assert.state(pais != null, "Você está tentando inserir um estado em um País que não existe");
		return new Estado(nome, pais);
	}

	@Override
	public String toString() {
		return "NovoEstadoForm [nome=" + nome + ", idPais=" + idPais + "]";
	}
	
	
}
