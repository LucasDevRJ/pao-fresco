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

	public void setQuantidadeQuilos(Integer quantidadeQuilos) {
		this.quantidadeQuilos = quantidadeQuilos;
	}

	public void setPesoGramas(Double pesoGramas) {
		this.pesoGramas = pesoGramas;
	}

	@Override
	public String toString() {
		return "|ID: " + this.id + "|Nome: " + this.nome + 
		"|Descrição: " + this.descricao + "|Preço: R$" +
		this.preco + "|Quantidade(kg): " + this.quantidadeQuilos +
		"|Peso(gramas): " + this.pesoGramas + "|";
	}
}