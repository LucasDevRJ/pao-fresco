package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

public class MercadoDao {

	private EntityManager em;
	
	public MercadoDao(EntityManager em) {
		this.em = em;
	}
}
