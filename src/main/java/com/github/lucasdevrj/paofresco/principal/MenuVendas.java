package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuVendas {
	
private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibeMenu();
	}
	
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
		lanchoneteDao.exibirTodos();
		
		System.out.print("Digite o ID da lanchonete que você trabalha: ");
		int idLanchonete = entrada.nextInt();
		
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(idLanchonete);
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		salgadoDao.exibirTodos();
		
		System.out.print("Digite o ID do salgado desejado pelo cliente: ");
		int idSalgado = entrada.nextInt();
		
		Salgado salgado = salgadoDao.buscarPorId(idSalgado);
		
		
	}
}
