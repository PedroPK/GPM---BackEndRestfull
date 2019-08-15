package br.com.tecdainfor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

// Classe Monitor

@Entity
@Table(name = "TB_MONITOR")
public class Monitor implements Serializable {
	
	// Atributos da classe monitor

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monitor_pk", nullable = false)
	private int id;
	@Column(name = "st_montomb")
	private String montomb;
	@Column(name = "st_modelo")
	private String modelo;
	@Column(name = "st_descricao")
	private String descricao;
	
	
	 @JsonBackReference
	@ManyToOne(targetEntity = Setor.class)
	 private Setor setor;
	
	
	
	//Gets and Sets da classe monitor
	
	 
	
	
	 
	public int getId() {
		return id;
	}
	


	public Setor getSetor() {
		return setor;
	}



	public void setSetor(Setor setor) {
		this.setor = setor;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getMontomb() {
		return montomb;
	}
	public void setMontomb(String montomb) {
		this.montomb = montomb;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
