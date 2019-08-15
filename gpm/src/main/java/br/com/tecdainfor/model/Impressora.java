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

@Entity
@Table(name = "TB_IMPRESSORA")
public class Impressora  implements Serializable {
	
	// Atributos da classe Impressora

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_impressora_pk", nullable = false)	
	private int id;
	@Column(name = "st_descricao")
	private String descricao;
	@Column(name = "st_ip")
	private String ip;
	@Column(name = "st_ramal")
	private int ramal;
	@Column(name = "st_num_serie")
	private String num_serie;
	@Column(name = "st_modelo")
	private String modelo;
	
	 @JsonBackReference
	@ManyToOne(targetEntity = Setor.class)
	 private Setor setor;
	
	
	
	// Geters e Seters da classe Impressora
	
	
	
	 
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRamal() {
		return ramal;
	}
	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public String getNum_serie() {
		return num_serie;
	}
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
