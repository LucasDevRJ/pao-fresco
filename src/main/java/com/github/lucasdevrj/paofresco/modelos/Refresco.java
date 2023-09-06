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
	
	public Refresco(String nome, String descricao, Double preco, Double mililitros) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.mililitros = mililitros;
	}
	
	public Refresco() {
		
	}
}
