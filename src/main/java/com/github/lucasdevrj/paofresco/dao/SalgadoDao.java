package com.github.lucasdevrj.paofresco.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Salgado;

public class SalgadoDao {

	private EntityManager em;
	
	public SalgadoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Salgado salgado) {
		this.em.persist(salgado);
	}
	
	public void atualizar(Salgado salgado) {
		this.em.merge(salgado);
	}
	
	public Salgado buscarPorId(Integer id) {
		return this.em.find(Salgado.class, id);
	}
	
	public void excluir(Salgado salgado) {
		salgado = this.em.merge(salgado);
		this.em.remove(salgado);
	}
	
	public List<Salgado> pesquisarSalgado(String nome) {
		String jpql = "SELECT s FROM Salgado s WHERE s.nome = :nome";
		return this.em.createQuery(jpql, Salgado.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	
}
