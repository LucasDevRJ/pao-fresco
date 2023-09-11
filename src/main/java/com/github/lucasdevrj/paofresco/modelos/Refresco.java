package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "refrescos")
public class Refresco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private Double mililitros;
	private Integer quantidade;
	
	public Refresco(String nome, String descricao, Double preco, Double mililitros, Integer quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.mililitros = mililitros;
		this.quantidade = quantidade;
	}
	
	public Refresco() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getMililitros() {
		return mililitros;
	}

	public void setMililitros(Double mililitros) {
		this.mililitros = mililitros;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "|Nome: " + this.nome +
		"|Descrição: " + this.descricao + "|Preço: " +
		this.preco + "|Mililitros: " + this.mililitros +
		"|Quantidade: " + this.quantidade;
	}
}
