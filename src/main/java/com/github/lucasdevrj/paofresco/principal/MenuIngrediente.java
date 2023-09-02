package com.github.lucasdevrj.paofresco.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.IngredienteDao;
import com.github.lucasdevrj.paofresco.dao.IngredienteDao;
import com.github.lucasdevrj.paofresco.modelos.Ingrediente;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuIngrediente {
	
	private Scanner entrada = new Scanner(System.in);

	public void exibeMenu() {
		System.out.println("--------------------|MENU SALGADO|--------------------");
		System.out.println("1 - Pesquisar Ingrediente");
		System.out.println("2 - Exibir Todos Ingredientes");
		System.out.println("3 - Atualizar Ingrediente");
		System.out.println("4 - Excluir Ingrediente");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				
			break;
			
			case 2:
				exibirTodosIngredientes();
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

	private void exibirTodosIngredientes() {
		EntityManager em = JPAUtil.getEntityManager();
		
		IngredienteDao ingredienteDao = new IngredienteDao(em);
		List<Ingrediente> ingredientes = ingredienteDao.exibirTodos();
		ingredientes.forEach(e -> System.out.println(e));
	}

	
}
