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
	private Integer id;
	private String nome;
	private Double quantidadeGramas;
	private Double preco;
	
	public Ingrediente(String nome, Double quantidadeGramas, Double preco) {
		this.nome = nome;
		this.quantidadeGramas = quantidadeGramas;
		this.preco = preco;
	}
	
	public Ingrediente() {
		
	}
}
