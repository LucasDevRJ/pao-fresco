package com.github.lucasdevrj.paofresco.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lanchonetes")
public class Lanchonete {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome = "Pão Fresco";
	private String endereco;
	
	public Lanchonete(String endereco) {
		this.endereco = endereco;
	}
	
	public Lanchonete() {
		
	}

	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "|Nome: " + 
		this.nome + "|Endereço: " + this.endereco;
	}
}
