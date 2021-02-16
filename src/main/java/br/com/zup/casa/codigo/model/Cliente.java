package br.com.zup.casa.codigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Email String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank String cpfOuCnpj;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	@ManyToOne
	private @NotNull @Valid Pais pais;
	@ManyToOne
	private @NotNull @Valid Estado estado;
	private @NotBlank String telefone;
	private @NotBlank String cep;

	@Deprecated
	public Cliente() {
		
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull @Valid Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpfOuCnpj=" + cpfOuCnpj
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", pais=" + pais
				+ ", estado=" + estado + "]";
	}

	public void setEstado(@NotNull @Valid Estado estado) {
		this.estado = estado;
	}

	
	
}
