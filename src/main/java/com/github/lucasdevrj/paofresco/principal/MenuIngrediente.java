package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

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
}
