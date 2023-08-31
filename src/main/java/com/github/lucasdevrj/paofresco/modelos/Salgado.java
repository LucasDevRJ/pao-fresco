package com.github.lucasdevrj.paofresco.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salgados")
public class Salgado extends Alimento {

	private Double quantidadeGramas;
	private Double pesoGramas;
	
	public Salgado(String nome, List<Ingrediente> ingredientes, String descricao, Double preco, Double quantidadeGramas,
			Double pesoGramas) {
		super(nome, ingredientes, descricao, preco);
		this.quantidadeGramas = quantidadeGramas;
		this.pesoGramas = pesoGramas;
	}

	public Salgado() {
		
	}

	public Double getQuantidadeGramas() {
		return quantidadeGramas;
	}

	public void setQuantidadeGramas(Double quantidadeGramas) {
		this.quantidadeGramas = quantidadeGramas;
	}

	public Double getPesoGramas() {
		return pesoGramas;
	}

	public void setPesoGramas(Double pesoGramas) {
		this.pesoGramas = pesoGramas;
	}
	
	
}