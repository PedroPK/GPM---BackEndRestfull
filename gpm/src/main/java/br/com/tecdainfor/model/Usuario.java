package br.com.tecdainfor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

// Classe Usuário.

@Entity
@Table(name = "TB_USUARIO")
public class Usuario  implements Serializable {
	
	//Atributos da classe usuário
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_pk", nullable = false)
	private int id;
	@Column(name = "st_nome")
	private String nome;
	@Column(name = "st_email")
	private String email;
	@Column(name = "st_senha")
	private String senha;
	@Column(name = "st_telefone")
	private String telefone;
	@Column(name = "st_cargo")
	private String cargo;
	@Column(name = "st_matricula")
	private int matricula;
	
	//Gets e Sets da classe usuário.
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}





	
	
}
