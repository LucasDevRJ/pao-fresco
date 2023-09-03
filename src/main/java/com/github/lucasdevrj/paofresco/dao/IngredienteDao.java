package com.github.lucasdevrj.paofresco.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.modelos.Ingrediente;
import com.github.lucasdevrj.paofresco.modelos.Salgado;

public class IngredienteDao {

	private EntityManager em;
	
	public IngredienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Ingrediente ingrediente) {
		this.em.persist(ingrediente);
	}
	
	public void atualizar(Ingrediente ingrediente) {
		this.em.merge(ingrediente);
	}
	
	public Ingrediente buscarPorId(Integer id) {
		return this.em.find(Ingrediente.class, id);
	}
	
	public void excluir(Ingrediente ingrediente) {
		ingrediente = this.em.merge(ingrediente);
		this.em.remove(ingrediente);
	}
	
	public List<Ingrediente> pesquisarSalgado(String nome) {
		String jpql = "SELECT i FROM Ingrediente i WHERE i.nome = :nome";
		return this.em.createQuery(jpql, Ingrediente.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Ingrediente> exibirTodos() {
		String jpql = "SELECT i FROM Ingrediente i";
		return this.em.createQuery(jpql, Ingrediente.class).getResultList();
	}
}
