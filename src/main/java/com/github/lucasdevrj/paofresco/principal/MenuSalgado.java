package com.github.lucasdevrj.paofresco.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuSalgado {
	
	private Scanner entrada = new Scanner(System.in);
	
	public void exibeMenu() {
		System.out.println("--------------------|MENU SALGADO|--------------------");
		System.out.println("1 - Cadastrar Salgado");
		System.out.println("2 - Pesquisar Salgado");
		System.out.println("3 - Exibir Todos Salgados");
		System.out.println("4 - Atualizar Salgado");
		System.out.println("5 - Excluir Salgado");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarSalgado();
			break;
			
			case 2:
				pesquisarSalgado();
			break;
			
			case 3:
				exibirTodosSalgados();
			break;
			
			case 4:
				atualizarSalgado();
			break;
			
			case 5:
				excluirSalgado();
			break;
		}
		exibeMenu();
	}

	private void cadastrarSalgado() {
		this.entrada.nextLine();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite o nome do salgado: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a descrição do salgado: ");
		String descricao = entrada.nextLine();
		
		System.out.print("Digite o preço unitário do salgado: ");
		Double preco = entrada.nextDouble();
		
		System.out.print("Digite o peso unitário do salgado: ");
		Double peso = entrada.nextDouble();

		Salgado salgado = new Salgado(nome, descricao, preco, peso);
		SalgadoDao salgadoDao = new SalgadoDao(em);

		em.getTransaction().begin();
		
		salgadoDao.cadastrar(salgado);
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Salgado cadastrado com sucesso!");
	}
	
	private void atualizarSalgado() {
		System.out.print("Digite o ID do salgado desejado: ");
		Integer id = entrada.nextInt();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		Salgado salgado = salgadoDao.buscarPorId(id);
		
		this.entrada.nextLine();
		
		System.out.print("Digite o nome do salgado: ");
		salgado.setNome(entrada.nextLine());
		
		System.out.print("Digite a descrição do salgado: ");
		salgado.setDescricao(entrada.nextLine());
		
		System.out.print("Digite o preço unitário do salgado: ");
		salgado.setPreco(entrada.nextDouble());
		
		System.out.print("Digite a quantidade(gramas) disponível do salgado: ");
		salgado.setPesoGramas(entrada.nextDouble());
		
		System.out.print("Digite o peso unitário do salgado: ");
		salgado.setPesoGramas(entrada.nextDouble());
		
		em.getTransaction().begin();
		
		salgadoDao.atualizar(salgado);
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Salgado atualizado com sucesso!");
	}
	
	private void pesquisarSalgado() {
		entrada.nextLine();
		
		System.out.print("Digite o nome do salgado desejado: ");
		String nome = entrada.nextLine();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		List<Salgado> salgados = salgadoDao.pesquisarSalgado(nome);
		salgados.forEach(s -> System.out.println(s));
	}
	
	private void exibirTodosSalgados() {
		EntityManager em = JPAUtil.getEntityManager();
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		List<Salgado> salgados = salgadoDao.exibirTodos();
		salgados.forEach(s -> System.out.println(s));
	}
	
	private void excluirSalgado() {
		System.out.print("Digite o ID do salgado desejado: ");
		Integer id = entrada.nextInt();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		Salgado salgado = salgadoDao.buscarPorId(id);
		em.getTransaction().begin();
		salgadoDao.excluir(salgado);
		em.getTransaction().commit();
		em.close();
		System.out.println("Salgado excluído com sucesso!");
	}
}
