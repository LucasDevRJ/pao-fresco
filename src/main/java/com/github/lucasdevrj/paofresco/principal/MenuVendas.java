package com.github.lucasdevrj.paofresco.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.dao.RefrescoDao;
import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Refresco;
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
				MenuPrincipal.exibeMenu();
			break;
		}
	}

	private static void vender() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		List<Lanchonete> lanchonetes = lanchoneteDao.exibirTodos();
		lanchonetes.forEach(l -> System.out.println(l));
		
		System.out.print("Digite o ID da lanchonete que você trabalha: ");
		int idLanchonete = entrada.nextInt();
		
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(idLanchonete);
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		List<Salgado> salgados = salgadoDao.exibirTodos();
		salgados.forEach(s -> System.out.println(s));
		double precoTotal = 0.0;
		String resposta;
		Salgado salgado;
		do {
			System.out.print("Digite o ID do salgado desejado pelo cliente: ");
			int idSalgado = entrada.nextInt();
			
			System.out.print("Digite a quantidade desejada: ");
			int quantidadeSalgado = entrada.nextInt();
			
			salgado = salgadoDao.buscarPorId(idSalgado);
			
			List<Salgado> salgadosEscolhidos = new ArrayList<>();
			salgadosEscolhidos.add(salgado);
			
			salgado.setQuantidade(salgado.getQuantidade() - quantidadeSalgado);
			precoTotal += salgado.getPreco() * quantidadeSalgado;
			
			salgadoDao.atualizar(salgado);
			
			System.out.println("Deseja comprar outro salgado?\ns ou n");
			resposta = entrada.next();
		} while (resposta.equals("s"));
		
		RefrescoDao refrescoDao = new RefrescoDao(em);
		List<Refresco> refrescos = refrescoDao.exibirTodos();
		refrescos.forEach(r -> System.out.println(r));
		
		Refresco refresco;
		do {
			System.out.print("Digite o ID do refresco desejado pelo cliente: ");
			int idRefresco = entrada.nextInt();
			
			refresco = refrescoDao.buscarPorId(idRefresco);
			
			List<Refresco> refrescosEscolhidos = new ArrayList<>();
			refrescosEscolhidos.add(refresco);
			
			precoTotal += refresco.getPreco();
			
			refrescoDao.atualizar(refresco);
			
			System.out.println("Deseja comprar outro refresco?\ns ou n");
			resposta = entrada.next();
		} while (resposta.equals("s"));
		
		lanchonete.setReceita(lanchonete.getReceita() + precoTotal);
		
		lanchoneteDao.atualizar(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Vendido(s) com Sucesso!");
		salgados.forEach(s -> System.out.println("Salgado: " + s.getNome()
		+"\nPreço: R$" + s.getPreco()));
		refrescos.forEach(r -> System.out.println("Refresco: " + r.getNome()
		+ "\nPreço: R$ " + r.getPreco()));
		System.out.println("Preço Total: R$ " + precoTotal);
	}
}
