package com.github.lucasdevrj.paofresco.principal;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuVenda {
	
	private Scanner entrada = new Scanner(System.in);
	private EntityManager em = JPAUtil.getEntityManager();

	public void vender() {
		SalgadoDao salgadoDao = new SalgadoDao(em);
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		salgadoDao.exibirTodos();
		
		System.out.print("Digite o ID do salgado desejado pelo cliente: ");
		int id = entrada.nextInt();
		
		System.out.print("Digite a quantidade do salgado desejado pelo cliente: ");
		int quantidade = entrada.nextInt();
		
		Salgado salgado = salgadoDao.buscarPorId(id);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(1);
		
		double quantidadeGramasSalgadoDesejados = salgado.getPesoGramas() * quantidade;
		double valorTotalVendido = salgado.getPreco() * quantidade;
		salgado.setQuantidadeGramas(salgado.getQuantidadeGramas() - quantidadeGramasSalgadoDesejados);
		
		lanchonete.setReceita(lanchonete.getReceita() + valorTotalVendido);
		
		this.em.getTransaction().begin();
		
		salgadoDao.atualizar(salgado);
		
		this.em.getTransaction().commit();
		this.em.close();
		
		System.out.println("Salgado vendido com sucesso!");
	}
}
