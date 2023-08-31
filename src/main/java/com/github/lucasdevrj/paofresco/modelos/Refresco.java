package com.github.lucasdevrj.paofresco.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "refrescos")
public class Refresco extends Alimento {

	private Double mililitros;

	public Refresco(String nome, List<Ingrediente> ingredientes, String descricao, Double preco, Double mililitros) {
		super(nome, ingredientes, descricao, preco);
		this.mililitros = mililitros;
	}
	
	public Refresco() {
		
	}

	public Double getMililitros() {
		return mililitros;
	}

	public void setMililitros(Double mililitros) {
		this.mililitros = mililitros;
	}
	
	@Override
	public String toString() {
		return super.toString() + "|Mililitros: " + this.mililitros;
	}
	
}
