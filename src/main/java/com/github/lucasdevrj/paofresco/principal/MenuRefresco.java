package com.github.lucasdevrj.paofresco.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.RefrescoDao;
import com.github.lucasdevrj.paofresco.modelos.Refresco;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

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
				pesquisarRefresco();
			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
			
			case 5:
				
			break;
		}
	}

	private void pesquisarRefresco() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o refresco desejado: ");
		String nome = entrada.nextLine();
		
		RefrescoDao refrescoDao = new RefrescoDao(em);
		List<Refresco> refrescos = refrescoDao.pesquisarRefresco(nome);
		refrescos.forEach(r -> System.out.println(r));
		exibeMenu();
	}

	private void cadastrarRefresco() {
		entrada.nextLine();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o nome do refresco: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a descrição do refresco: ");
		String descricao = entrada.nextLine();
		
		System.out.print("Digite o preço do refresco: ");
		Double preco = entrada.nextDouble();
		
		System.out.print("Digite a quantidade(mililitros) do refresco: ");
		Double mililitros = entrada.nextDouble();
		
		Refresco refresco = new Refresco(nome, descricao, preco, mililitros);
		RefrescoDao refrescoDao = new RefrescoDao(em);
		
		em.getTransaction().begin();
		refrescoDao.adicionar(refresco);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Ingrediente cadastrado com sucesso!");
		exibeMenu();
	}

}
