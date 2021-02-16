package br.com.zup.casa.codigo.controller.request;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zup.casa.codigo.annotation.ExistsId;
import br.com.zup.casa.codigo.annotation.UniqueValue;
import br.com.zup.casa.codigo.model.Cliente;
import br.com.zup.casa.codigo.model.Estado;
import br.com.zup.casa.codigo.model.Pais;

public class NovoClienteRequest {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String cpfOuCnpj;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.telefone = telefone;
		this.cep = cep;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Cliente toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		
		Cliente cliente =new Cliente(email, nome, sobrenome, cpfOuCnpj, endereco, complemento, cidade, pais, telefone, cep);
		
		if(idEstado != null) {
			cliente.setEstado(manager.find(Estado.class, idEstado));
		}
		return cliente;
	}
	public boolean temEstado() {
		return Optional.ofNullable(idEstado).isPresent();
	}
	public Long getIdPais() {
		return idPais;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public boolean documentoValido() {
		Assert.hasLength(cpfOuCnpj,
				"você nao deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(cpfOuCnpj, null)
				|| cnpjValidator.isValid(cpfOuCnpj, null);
	}
	
	
}
