package com.github.lucasdevrj.paofresco.modelos;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.IngredienteDao;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class Mercado {

	private String nome;
	
	public void comprar() {
		EntityManager em = JPAUtil.getEntityManager();
		Scanner entrada = new Scanner(System.in);
		String resposta = "";
		do {
			System.out.print("Digite o nome do ingrediente que deseja comprar: ");
			String nome = entrada.nextLine();
			
			System.out.print("Digite a quantidade(gramas) do ingrediente que deseja comprar: ");
			double gramas = entrada.nextDouble();
			
			System.out.print("Deseja comprar outro ingrediente?\ns ou n: ");
			resposta = entrada.next();
			
			double preco = 8.00;
			if (gramas >= 100) {
				for (int i = 100; i < gramas; i+= 100) {
					preco += 8.00;
				}
			}
	
			Ingrediente ingrediente = new Ingrediente(nome, gramas, preco);
			IngredienteDao ingredienteDao = new IngredienteDao(em);
			
			em.getTransaction().begin();
			ingredienteDao.cadastrar(ingrediente);
			em.getTransaction().commit();
			System.out.println("Ingrediente comprado com sucesso!");
		} while (resposta == "s");
		em.close();
		entrada.close();
	}
}
