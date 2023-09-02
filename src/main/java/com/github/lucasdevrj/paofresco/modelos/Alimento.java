package com.github.lucasdevrj.paofresco.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alimentos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private Double preco;
	
	public Alimento(String nome, String descricao, List<Ingrediente> ingredientes, Double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.ingredientes = ingredientes;
		this.preco = preco;
	}

	public Alimento() {
		
	}
	
	public Integer getId() {
		return id;
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
	
	@Override
	public String toString() {
		return "ID: " + this.id + "|Nome: " + this.nome + "|Descrição: " +
		this.descricao + "|Preço: " + 
		this.preco;
	}
}
