package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

public class MenuVendas {
	
private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibeMenu();
	}
	
	public static void exibeMenu() {
		System.out.println("--------------------|MENU VENDAS|--------------------");
		System.out.println("1 - Vender");
		System.out.println("2 - Sair");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				
			break;
			
			case 2:
				
			break;
		}
	}
}
