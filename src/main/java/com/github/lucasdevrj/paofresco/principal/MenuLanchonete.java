package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

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
				
			break;
			
			case 2:
				
			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
		}
	}
}
