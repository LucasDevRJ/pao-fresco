package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import com.github.lucasdevrj.paofresco.modelos.Mercado;

public class MenuPrincipal {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("--------------------|MENU PRINCIPAL|--------------------");
		System.out.println("1 - Menu Salgados");
		System.out.println("2 - Menu Refrescos");
		System.out.println("3 - Menu Ingredientes");
		System.out.println("4 - Menu Lanchonete");
		System.out.println("5 - Menu Mercado");
		System.out.println("6 - Vender");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
				case 1:
					MenuSalgado menuSalgado = new MenuSalgado();
					menuSalgado.exibeMenu();
				break;
				
				case 2:
					MenuRefresco menuRefresco = new MenuRefresco();
				break;
				
				case 3:
					MenuIngrediente menuIngrediente = new MenuIngrediente();
					menuIngrediente.exibeMenu();
				break;
				
				case 4:
					Mercado mercado = new Mercado();
					mercado.comprar();
				break;
				
				case 5:
					MenuVenda menuVenda = new MenuVenda();
					menuVenda.vender();
				break;
				
				case 6:
					MenuLanchonete lanchonete = new MenuLanchonete();
					lanchonete.exibeMenu();
				break;
		}
	}
}
