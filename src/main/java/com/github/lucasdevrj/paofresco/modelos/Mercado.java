package com.github.lucasdevrj.paofresco.modelos;

import java.util.Scanner;

public class Mercado {

	private String nome;
	
	public void comprar() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o nome do ingrediente que deseja comprar: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a quantidade(gramas) do ingrediente que deseja comprar: ");
		double gramas = entrada.nextDouble();
		
		Ingrediente ingrediente = new Ingrediente(nome, gramas);
		
	}
}
