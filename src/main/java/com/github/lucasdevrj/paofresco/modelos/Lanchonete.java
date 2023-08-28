package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lanchonetes")
public class Lanchonete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome = "Pão Fresco";
	private String endereco;
	private Double receita;
	
	public Lanchonete(String endereco, Double receita) {
		this.endereco = endereco;
		this.receita = receita;
	}

	public Lanchonete() {
		
	}
	
	public Double getReceita() {
		return receita;
	}
	
	public void setReceita(Double receita) {
		this.receita = receita;
	}
}
