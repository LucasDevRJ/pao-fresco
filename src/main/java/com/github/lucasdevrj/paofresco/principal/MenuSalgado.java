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

	public void cadastrarSalgado() {
		System.out.print("Digite o nome do salgado: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a descrição do salgado: ");
		String descricao = entrada.nextLine();
		
		System.out.print("Digite o preço do salgado: ");
		BigDecimal preco = entrada.nextBigDecimal();
		
		System.out.print("Digite a quantidade do salgado: ");
		Integer quantidade = entrada.nextInt();
		
		Salgado salgado = new Salgado(nome, descricao, preco, quantidade);
		SalgadoDao salgadoDao = new SalgadoDao(em);
		salgadoDao.cadastrar(salgado);
		
	}
}
