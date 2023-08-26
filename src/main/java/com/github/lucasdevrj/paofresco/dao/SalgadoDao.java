package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

public class SalgadoDao {

	private EntityManager em;
	
	public SalgadoDao(EntityManager em) {
		this.em = em;
	}
}
