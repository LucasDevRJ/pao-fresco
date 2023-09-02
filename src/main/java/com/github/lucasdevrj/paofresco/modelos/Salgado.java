package com.github.lucasdevrj.paofresco.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salgados")
public class Salgado extends Alimento {

	private Double pesoGramas;
	
	public Salgado(String nome, String descricao, List<Ingrediente> ingredientes, Double preco, Double pesoGramas) {
		super(nome, descricao, ingredientes, preco);
		this.pesoGramas = pesoGramas;
	}

	public Salgado() {
		
	}
	
	public void setPesoGramas(Double pesoGramas) {
		this.pesoGramas = pesoGramas;
	}
	
	public Double getPesoGramas() {
		return pesoGramas;
	}
	
	@Override
	public String toString() {
		return super.toString() + "| Peso(gramas): " + this.pesoGramas;
	}
}