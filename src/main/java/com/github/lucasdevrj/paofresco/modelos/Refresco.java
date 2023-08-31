package com.github.lucasdevrj.paofresco.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "refrescos")
public class Refresco extends Alimento {

	private Double mililitros;
	private Double preco;
	
	public Refresco(String nome, List<Ingrediente> ingredientes, String descricao, Double preco, Double mililitros,
			Double preco2) {
		super(nome, ingredientes, descricao, preco);
		this.mililitros = mililitros;
		preco = preco2;
	}
	
	public Refresco() {
		
	}
}
