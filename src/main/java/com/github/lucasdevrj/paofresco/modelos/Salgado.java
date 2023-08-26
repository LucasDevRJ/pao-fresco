package com.github.lucasdevrj.paofresco.modelos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salgados")
public class Salgado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer quantidadeQuilos;
	private Double pesoGramas;

	public Salgado(String nome, String descricao, BigDecimal preco, Integer quantidadeQuilos, Double pesoGramas) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeQuilos = quantidadeQuilos;
		this.pesoGramas = pesoGramas;
	}

	public Salgado() {
		
	}
}
