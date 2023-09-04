package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class RefrescoDao {

	private EntityManager em = JPAUtil.getEntityManager();
	
	public RefrescoDao(EntityManager em) {
		this.em = em;
	}
	
	
}
