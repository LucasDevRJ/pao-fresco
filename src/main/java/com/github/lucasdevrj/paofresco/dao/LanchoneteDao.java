package com.github.lucasdevrj.paofresco.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Salgado;

public class LanchoneteDao {

	private EntityManager em;
	
	public LanchoneteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Lanchonete lanchonete) {
		this.em.persist(lanchonete);
	}
	
	public void atualizar(Lanchonete lanchonete) {
		this.em.merge(lanchonete);
	}
	
	public Lanchonete buscarPorId(Integer id) {
		return this.em.find(Lanchonete.class, id);
	}
	
	public void excluir(Lanchonete lanchonete) {
		lanchonete = this.em.merge(lanchonete);
		this.em.remove(lanchonete);
	}
	
	public List<Salgado> exibirTodos() {
		String jpql = "SELECT l FROM Lanchonete l";
		return this.em.createQuery(jpql, Salgado.class).getResultList();
	}
}
