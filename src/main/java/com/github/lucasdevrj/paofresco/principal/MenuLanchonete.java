package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuLanchonete {
	
	private Scanner entrada = new Scanner(System.in);
	private EntityManager em = JPAUtil.getEntityManager();

	public void exibeMenu() {
		System.out.println("--------------------|MENU SALGADO|--------------------");
		System.out.println("1 - Cadastrar Lanchonete");
		System.out.println("2 - Pesquisar Lanchonete");
		System.out.println("3 - Exibir Todos Lanchonetes");
		System.out.println("4 - Atualizar Lanchonete");
		System.out.println("5 - Excluir Lanchonete");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarLanchonete();
			break;
		}
		exibeMenu();
	}

	private void cadastrarLanchonete() {
		this.entrada.nextLine();
		
		System.out.print("Digite o endereço da lanchonete: ");
		String endereco = entrada.nextLine();
		
		Lanchonete lanchonete = new Lanchonete(endereco);
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		
		this.em.getTransaction().begin();
		lanchoneteDao.cadastrar(lanchonete);
		this.em.getTransaction().commit();
		this.em.close();
		
		System.out.println("Lanchonete cadastrada com sucesso!");
	}
}
