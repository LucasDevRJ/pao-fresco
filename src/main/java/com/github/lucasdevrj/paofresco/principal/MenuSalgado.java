package com.github.lucasdevrj.paofresco.principal;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.paofresco.dao.SalgadoDao;
import com.github.lucasdevrj.paofresco.modelos.Salgado;
import com.github.lucasdevrj.paofresco.util.JPAUtil;

public class MenuSalgado {
	
	private Scanner entrada = new Scanner(System.in);
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void exibeMenu() {
		System.out.println("--------------------|MENU SALGADO|--------------------");
		System.out.println("1 - Cadastrar Salgado");
		System.out.println("2 - Atualizar Salgado");
		System.out.print("Digite a opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarSalgado();
			break;
			
			case 2:
				atualizarSalgado();
			break;
		}
	}

	public void cadastrarSalgado() {
		entrada.nextLine();
		
		System.out.print("Digite o nome do salgado: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a descrição do salgado: ");
		String descricao = entrada.nextLine();
		
		System.out.print("Digite o preço unitário do salgado: ");
		BigDecimal preco = entrada.nextBigDecimal();
		
		System.out.print("Digite a quantidade(kg) disponível do salgado: ");
		Integer quantidade = entrada.nextInt();
		
		System.out.print("Digite o peso unitário do salgado: ");
		Double peso = entrada.nextDouble();
		
		Salgado salgado = new Salgado(nome, descricao, preco, quantidade, peso);
		SalgadoDao salgadoDao = new SalgadoDao(em);
		
		em.getTransaction().begin();
		
		salgadoDao.cadastrar(salgado);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizarSalgado() {
		System.out.print("Digite o ID do salgado desejado: ");
		Integer id = entrada.nextInt();
		
		SalgadoDao salgadoDao = new SalgadoDao(em);
		Salgado salgado = salgadoDao.buscarPorId(id);
		
		System.out.print("Digite o nome do salgado: ");
		salgado.setNome(entrada.nextLine());
		
		System.out.print("Digite a descrição do salgado: ");
		salgado.setDescricao(entrada.nextLine());
	}
}
