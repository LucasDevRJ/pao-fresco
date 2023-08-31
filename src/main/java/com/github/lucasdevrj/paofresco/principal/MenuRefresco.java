package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

public class MenuRefresco {

	private Scanner entrada = new Scanner(System.in);
	
	public void exibeMenu() {
		System.out.println("--------------------|MENU REFRESCO|--------------------");
		System.out.println("1 - Cadastrar Refresco");
		System.out.println("2 - Pesquisar Refresco");
		System.out.println("3 - Exibir Todos Refresco");
		System.out.println("4 - Atualizar Refresco");
		System.out.println("5 - Excluir Refresco");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarRefresco();
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

	private void cadastrarRefresco() {
		
	}

}
