package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

public class MenuPrincipal {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibeMenu();
	}
	
	private static void exibeMenu() {
		System.out.println("--------------------|MENU PRINCIPAL|--------------------");
		System.out.println("1 - Menu Lanchonete");
		System.out.println("2 - Menu Salgado");
		System.out.println("3 - Menu Refresco");
		System.out.println("4 - Sair");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				MenuSalgado menuSalgado = new MenuSalgado();
				menuSalgado.exibeMenu();
			break;
			
			case 2:
				MenuRefresco menuRefresco = new MenuRefresco();
				menuRefresco.exibeMenu();
			break;
			
			case 3:
				MenuVenda menuVenda = new MenuVenda();
				menuVenda.vender();
			break;
			
			case 4:
				finalizarPrograma();
			break;
		}
	}

	private static void finalizarPrograma() {
		System.out.println("Programa finalizado.");
		entrada.close();
	}
}
