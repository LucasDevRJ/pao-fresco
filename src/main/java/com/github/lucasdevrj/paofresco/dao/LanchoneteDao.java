package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Lanchonete;

public class LanchoneteDao {

private EntityManager em;
	
	public LanchoneteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Lanchonete lanchonete) {
		this.em.persist(lanchonete);
	}
	
	public Lanchonete buscarPorId(Integer id) {
		return this.em.find(Lanchonete.class, id);
	}
}
