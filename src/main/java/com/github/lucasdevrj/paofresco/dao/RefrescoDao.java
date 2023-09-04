package com.github.lucasdevrj.paofresco.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Refresco;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class RefrescoDao {

	private EntityManager em = JPAUtil.getEntityManager();
	
	public RefrescoDao(EntityManager em) {
		this.em = em;
	}
	
	public void adicionar(Refresco refresco) {
		this.em.persist(refresco);
	}
	
	public void buscarPorId(Integer id) {
		this.em.find(Refresco.class, id);
	}
	
	public void atualizar(Refresco refresco) {
		this.em.merge(refresco);
	}
	
	public void excluir(Refresco refresco) {
		refresco = this.em.merge(refresco);
		this.em.remove(refresco);
	}
}
