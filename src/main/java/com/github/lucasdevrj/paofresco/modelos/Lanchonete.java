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
}
