package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.IngredienteDao;
import com.github.lucasdevrj.paofresco.modelos.Ingrediente;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuIngrediente {
	
	private Scanner entrada = new Scanner(System.in);

	public void exibeMenu() {
		System.out.println("--------------------|MENU SALGADO|--------------------");
		System.out.println("1 - Cadastrar Ingrediente");
		System.out.println("2 - Pesquisar Ingrediente");
		System.out.println("3 - Exibir Todos Ingredientes");
		System.out.println("4 - Atualizar Ingrediente");
		System.out.println("5 - Excluir Ingrediente");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarIngrediente();
			break;
			
			case 2:
				
			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
			
			case 5:
				
			break;
		}
		exibeMenu();
	}

	private void cadastrarIngrediente() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o nome do ingrediente: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a quantidade(gramas) do ingrediente: ");
		Double quantidade = entrada.nextDouble();
		
		System.out.print("Digite o preço do ingrediente: ");
		Double preco = entrada.nextDouble();
		
		Ingrediente ingrediente = new Ingrediente(nome, quantidade, preco);
		IngredienteDao ingredienteDao = new IngredienteDao(em);
		
		em.getTransaction().begin();
		ingredienteDao.cadastrar(ingrediente);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Ingrediente cadastrado com sucessso!");
	}
}
