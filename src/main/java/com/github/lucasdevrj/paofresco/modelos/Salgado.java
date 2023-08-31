package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salgados")
public class Salgado extends Alimento {

	private Double quantidadeGramas;
	private Double pesoGramas;
	
	public Salgado(String nome, String descricao, Double preco, Double quantidadeGramas, Double pesoGramas) {
		super(nome, descricao, preco);
		this.quantidadeGramas = quantidadeGramas;
		this.pesoGramas = pesoGramas;
	}

	public Salgado() {
		
	}

	@Override
	public String toString() {
		return "|ID: " + super.getId() + "|Nome: " + super.getNome() + 
		"|Descrição: " + super.getDescricao() + "|Preço: R$" +
		super.getPreco() + "|Quantidade(kg): " + this.quantidadeGramas +
		"|Peso(gramas): " + this.pesoGramas + "|";
	}
}