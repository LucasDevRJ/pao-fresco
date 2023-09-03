package com.github.lucasdevrj.paofresco.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salgados")
public class Salgado {

	private String nome;
	private String descricao;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private Double preco;
	private Double pesoGramas;
}