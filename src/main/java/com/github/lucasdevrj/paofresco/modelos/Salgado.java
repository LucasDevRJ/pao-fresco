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
	private Double quantidadeGramas;
	private Double pesoGramas;

	public Salgado(String nome, String descricao, BigDecimal preco, Double quantidadeGramas, Double pesoGramas) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeGramas = quantidadeGramas;
		this.pesoGramas = pesoGramas;
	}

	public Salgado() {
		
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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

	@Override
	public String toString() {
		return "|ID: " + this.id + "|Nome: " + this.nome + 
		"|Descrição: " + this.descricao + "|Preço: R$" +
		this.preco + "|Quantidade(kg): " + this.quantidadeGramas +
		"|Peso(gramas): " + this.pesoGramas + "|";
	}
}