package com.github.lucasdevrj.paofresco.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.LanchoneteDao;
import com.github.lucasdevrj.paofresco.modelos.Lanchonete;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuLanchonete {

private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibeMenu();
	}
	
	private static void exibeMenu() {
		System.out.println("1 - Cadastrar Lanchonete");
		System.out.println("2 - Exibir Todas Lanchonetes");
		System.out.println("3 - Atualizar Lanchonete");
		System.out.println("4 - Excluir Lanchonete");
		System.out.println("5 - Voltar");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarLanchonete();
			break;
			
			case 2:
				exibirTodasLanchonetes();
			break;
			
			case 3:
				atualizarLanchonete();
			break;
			
			case 4:
				excluirLanchonete();
			break;
		}
	}

	private static void excluirLanchonete() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o ID da lanchonete desejada: ");
		int id = entrada.nextInt();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(id);
		
		em.getTransaction().begin();
		lanchoneteDao.excluir(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Lanchonete excluída com sucesso!");
	}

	private static void atualizarLanchonete() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o ID da lanchonete desejada: ");
		int id = entrada.nextInt();
		
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		Lanchonete lanchonete = lanchoneteDao.buscarPorId(id);
		
		System.out.print("Digite o novo endereço da lanchonete: ");
		lanchonete.setEndereco(entrada.nextLine());
		
		System.out.println("Lanchonete atualizada com sucesso!");
	}

	private static void exibirTodasLanchonetes() {
		EntityManager em = JPAUtil.getEntityManager();
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		List<Lanchonete> lanchonetes = lanchoneteDao.exibirTodos();
		lanchonetes.forEach(l -> System.out.println(l));
	}

	private static void cadastrarLanchonete() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o endereço da lanchonete: ");
		String endereco = entrada.nextLine();
		
		Lanchonete lanchonete = new Lanchonete(endereco);
		LanchoneteDao lanchoneteDao = new LanchoneteDao(em);
		
		em.getTransaction().begin();
		lanchoneteDao.cadastrar(lanchonete);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Lanchonete cadastrada com sucesso!");
	}
}
