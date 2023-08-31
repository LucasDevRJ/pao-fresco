package com.github.lucasdevrj.paofresco.principal;

import java.util.Scanner;

import com.github.lucasdevrj.paofresco.modelos.Mercado;

public class MenuPrincipal {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("--------------------|MENU PRINCIPAL|--------------------");
		System.out.println("1 - Menu Salgados");
		System.out.println("2 - Menu Refrescos");
		System.out.println("3 - Menu Lanchonete");
		System.out.println("4 - Menu Mercado");
		System.out.println("5 - Vender");
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
					MenuLanchonete menuLanchonete = new MenuLanchonete();
					menuLanchonete.exibeMenu();
				break;
				
				case 4:
					Mercado mercado = new Mercado();
					mercado.comprar();
				break;
				
				case 5:
					MenuVenda menuVenda = new MenuVenda();
					menuVenda.vender();
				break;
		}
	}
}
