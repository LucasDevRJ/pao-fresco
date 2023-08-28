package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nome;
	private Double quantidadeGramas;
	
	public Ingrediente(String nome, Double quantidadeGramas) {
		this.nome = nome;
		this.quantidadeGramas = quantidadeGramas;
	}
	
	public Ingrediente() {
		
	}
}
