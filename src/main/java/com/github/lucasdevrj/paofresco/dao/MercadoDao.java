package com.github.lucasdevrj.paofresco.dao;

import java.util.List;

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
	
	public Mercado buscarPorId(Integer id) {
		return this.em.find(Mercado.class, id);
	}
	
	public void atualizar(Mercado mercado) {
		this.em.merge(mercado);
	}
	
	public void excluir(Mercado mercado) {
		this.em.remove(mercado);
	}
	
	public List<Mercado> exibirTodos() {
		String jpql = "SELECT m FROM Mercado m";
		return this.em.createQuery(jpql, Mercado.class).getResultList();
	}
}
