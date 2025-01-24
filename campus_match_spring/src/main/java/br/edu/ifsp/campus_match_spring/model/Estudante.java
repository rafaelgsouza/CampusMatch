package br.edu.ifsp.campus_match_spring.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "estudante")
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	@NotBlank
	@Valid
	private String email;
	
	@Column(name="senha")
	@NotBlank
	@Length(min=6,max=25, message = "Tamanho de senha invalido: not between 6 and 25")
	@Valid
	private String senha;
	
	@Column(name="cep")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato invalido: CEP")
	@NotBlank
	@Length(max=9,min=9)
	@Valid
	private String cep;
	
	@Column(name="nome")
	@NotBlank
	@Length(min=3, max=100, message = "Tamanho de senha invalido: not between 3 and 100")
	@Valid
	private String nome;
	
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="validado")
	private int validado;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
	
	public String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public int getValidado() {
		return this.validado;
	}
	
	public void setValidado(int validado) {
		this.validado = validado;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
