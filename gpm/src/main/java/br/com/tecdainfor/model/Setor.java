package br.com.tecdainfor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TB_Setor")
public class Setor implements Serializable {
	
	// Atributos da classe setor
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_setor_pk", nullable = false)
	private int id;
	@Column(name = "nome_setor", nullable = false)
	private String nome;
	@Column(name = "descricao_setor", nullable = false)
	private String descricao;
	
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuariosporsetor", joinColumns=
	{@JoinColumn(name="id_setor_pk"),
	}, inverseJoinColumns=
	  {@JoinColumn(name="id_usuario_pk")})
	@Column(name = "listadeusuarios", nullable = false)
	private Collection<Usuario> listadeusuarios;
	
	

	@JsonManagedReference
	@OneToMany(mappedBy = "setor", targetEntity = Monitor.class, 
	fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "listademonitores", nullable = true)
	private Collection<Monitor> monitores;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "setor", targetEntity = Computador.class, 
	fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "listadecomputadores", nullable = true)
	private Collection<Computador> computadores;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "setor", targetEntity = Impressora.class, 
	fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "listadeimpressoras", nullable = true)
	private Collection<Impressora> impressoras;
	
	
	
	
	//Gets and Sets da classe setor
	
	
	
	public Collection<Usuario> getListadeusuarios() {
		return listadeusuarios;
	}

	public Collection<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(Collection<Monitor> monitores) {
		this.monitores = monitores;
	}

	public Collection<Computador> getComputadores() {
		return computadores;
	}

	public void setComputadores(Collection<Computador> computadores) {
		this.computadores = computadores;
	}

	public Collection<Impressora> getImpressoras() {
		return impressoras;
	}

	public void setImpressoras(Collection<Impressora> impressoras) {
		this.impressoras = impressoras;
	}

	public void setListadeusuarios(Collection<Usuario> listadeusuarios) {
		this.listadeusuarios = listadeusuarios;
	}

	public int getId() {
		return id;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}


