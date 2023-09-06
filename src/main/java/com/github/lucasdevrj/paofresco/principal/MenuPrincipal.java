package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

public class MenuPrincipal {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibeMenu();
	}
	
	public static void exibeMenu() {
		System.out.println("--------------------|MENU PRINCIPAL|--------------------");
		System.out.println("1 - Menu Lanchonete");
		System.out.println("2 - Menu Salgado");
		System.out.println("3 - Menu Refresco");
		System.out.println("4 - Sair");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				MenuLanchonete menuLanchonete = new MenuLanchonete();
				menuLanchonete.exibeMenu();
			break;
			
			case 2:
				MenuSalgado menuSalgado = new MenuSalgado();
				menuSalgado.exibeMenu();
			break;
			
			case 3:
				MenuRefresco menuRefresco = new MenuRefresco();
				menuRefresco.exibeMenu(); 
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
