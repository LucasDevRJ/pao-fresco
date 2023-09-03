package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "refrescos")
public class Refresco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private Double pesoGramas;
	
	public Refresco(String nome, String descricao, Double preco, Double pesoGramas) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.pesoGramas = pesoGramas;
	}
	
	public Refresco() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPesoGramas() {
		return pesoGramas;
	}

	public void setPesoGramas(Double pesoGramas) {
		this.pesoGramas = pesoGramas;
	}

	public Integer getId() {
		return id;
	}
}
