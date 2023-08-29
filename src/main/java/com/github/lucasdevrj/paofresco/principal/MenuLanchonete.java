package com.github.lucasdevrj.paofresco.principal;

import java.util.List;
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
			
			case 2:
				pesquisarLanchonete();
			break;
			
			case 3:
				exibirTodasLanchonetes();
			break;
			
			case 4:
				atualizarLanchonete();
			break;
			
			case 5:
				excluirLanchonete();
			break;
		}
		exibeMenu();
	}

	private void excluirLanchonete() {
		System.out.print("Digite o ID da lanchonete: ");
		int id = entrada.nextInt();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(id);
		
		em.getTransaction().begin();
		lanchoneteDao.excluir(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Lanchonete excluída com sucesso!");
	}

	private void atualizarLanchonete() {
		System.out.print("Digite o ID da lanchonete: ");
		int id = entrada.nextInt();
		
		entrada.nextLine();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(id);
		
		System.out.print("Digite o endereço da lanchonete: ");
		String endereco = entrada.nextLine();
		
		lanchonete.setEndereco(endereco);
		
		em.getTransaction().begin();
		lanchoneteDao.atualizar(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Lanchonete atualizada com sucesso!");
	}

	private void exibirTodasLanchonetes() {
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		List<Lanchonete> lanchonetes = lanchoneteDao.exibirTodas();
		lanchonetes.forEach(l -> System.out.println(l));
	}

	private void pesquisarLanchonete() {
		this.entrada.nextLine();
		
		System.out.print("Digite o ID da lanchonete: ");
		int id = entrada.nextInt();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(id);
		
		System.out.println(lanchonete);
	}

	private void cadastrarLanchonete() {
		this.entrada.nextLine();
		
		System.out.print("Digite o endereço da lanchonete: ");
		String endereco = entrada.nextLine();
		
		System.out.print("Digite a receita inicial da lanchonete: ");
		Double receita = entrada.nextDouble();
		
		Lanchonete lanchonete = new Lanchonete(endereco, receita);
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		
		em.getTransaction().begin();
		lanchoneteDao.cadastrar(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Lanchonete cadastrada com sucesso!");
	}
}
