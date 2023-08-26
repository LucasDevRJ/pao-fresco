package com.github.lucasdevrj.paofresco.modelos;

import java.math.BigDecimal;

public class Salgado {

	private Integer id;
	private String nome;
	private String descricao;
	private String ingrediente;
	private BigDecimal preco;
	private Integer quantidade;
	
	public Salgado(String nome, String descricao, String ingrediente, BigDecimal preco, Integer quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.ingrediente = ingrediente;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Salgado() {
		
	}
	
}
