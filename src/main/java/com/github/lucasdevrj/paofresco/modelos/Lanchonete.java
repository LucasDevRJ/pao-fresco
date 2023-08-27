package com.github.lucasdevrj.paofresco.modelos;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "lanchonetes")
public class Lanchonete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	private BigDecimal receita;
	
	public Lanchonete(String nome, String endereco, BigDecimal receita) {
		this.nome = "Pão Fresco";
		this.endereco = endereco;
		this.receita = receita;
	}
	
	
}
