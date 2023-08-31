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

	@Override
	public String toString() {
		return "|ID: " + this.id + "|Nome: " + this.nome + 
		"|Descrição: " + super.descricao + "|Preço: R$" +
		this.preco + "|Quantidade(kg): " + this.quantidadeGramas +
		"|Peso(gramas): " + this.pesoGramas + "|";
	}
}