package com.github.lucasdevrj.paofresco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY =
			Persistence.createEntityManagerFactory("pao_fresco");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
