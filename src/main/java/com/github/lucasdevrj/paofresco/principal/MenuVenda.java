package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuVenda {
	
	private Scanner entrada = new Scanner(System.in);
	private EntityManager em = JPAUtil.getEntityManager();

	public void vender() {
		SalgadoDao salgadoDao = new SalgadoDao(em);
		salgadoDao.exibirTodos();
		
		System.out.print("Digite o ID do salgado desejado pelo cliente: ");
		int id = entrada.nextInt();
		
		System.out.print("Digite a quantidade do salgado desejado pelo cliente: ");
		int quantidade = entrada.nextInt();
		
		Salgado salgado = salgadoDao.buscarPorId(id);
		
		double quantidadeGramasSalgadoDesejados = salgado.getPesoGramas() * quantidade;
		salgado.setQuantidadeGramas(salgado.getQuantidadeGramas() - quantidadeGramasSalgadoDesejados);
		
		this.em.getTransaction().begin();
		
		salgadoDao.atualizar(salgado);
		
		this.em.getTransaction().commit();
		this.em.close();
		
		System.out.println("Salgado vendido com sucesso!");
	}
}
