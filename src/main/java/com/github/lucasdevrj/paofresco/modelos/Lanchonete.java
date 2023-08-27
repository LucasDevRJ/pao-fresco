package com.github.lucasdevrj.paofresco.modelos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "lanchonete")
public class Lanchonete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private final String nome = "Pão Fresco";
	private String endereco;
	private BigDecimal receita;
}
