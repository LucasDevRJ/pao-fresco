package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Mercado;

public class MercadoDao {

	private EntityManager em;
	
	public MercadoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Mercado mercado) {
		this.em.persist(mercado);
	}
	
	public void atualizar(Mercado mercado) {
		this.em.merge(mercado);
	}
}
