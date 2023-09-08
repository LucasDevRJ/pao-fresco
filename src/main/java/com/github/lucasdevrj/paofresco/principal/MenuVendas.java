package com.github.lucasdevrj.paofresco.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuVendas {
	
private static Scanner entrada = new Scanner(System.in);
	
	public static void exibeMenu() {
		System.out.println("--------------------|MENU VENDAS|--------------------");
		System.out.println("1 - Vender");
		System.out.println("2 - Sair");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				vender();
			break;
			
			case 2:
				
			break;
		}
	}

	private static void vender() {
		EntityManager em = JPAUtil.getEntityManager();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		List<Lanchonete> lanchonetes = lanchoneteDao.exibirTodos();
		lanchonetes.forEach(l -> System.out.println(l));
		
		System.out.print("Digite o ID da lanchonete que você trabalha: ");
		int idLanchonete = entrada.nextInt();
		
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(idLanchonete);
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		List<Salgado> salgados = salgadoDao.exibirTodos();
		salgados.forEach(s -> System.out.println(s));
		
		System.out.print("Digite o ID do salgado desejado pelo cliente: ");
		int idSalgado = entrada.nextInt();
		
		System.out.print("Digite a quantidade desejada: ");
		int quantidade = entrada.nextInt();
		
		Salgado salgado = salgadoDao.buscarPorId(idSalgado);
		salgado.setQuantidade(salgado.getQuantidade() - quantidade);
		double precoTotal = salgado.getPreco() * quantidade;
		
		System.out.println(salgado.getQuantidade());
		
		lanchonete.setReceita(lanchonete.getReceita() + precoTotal);
		System.out.println(lanchonete.getReceita());
		em.getTransaction().begin();
		salgadoDao.atualizar(salgado);
		lanchoneteDao.atualizar(lanchonete);
		em.getTransaction().commit();
		em.close();
	}
}
