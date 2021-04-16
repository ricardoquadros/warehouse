package com.chintaly.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This Class is responsible for provide access to data(Data Access Object).
 * 
 * @author Ricardo Quadros.
 * @version 1.0
 * @since 09/01/2018
 */
public class SessionFactoryProvider {
	
	/**
	 * SessionFactory variable.
	 */	
	private static SessionFactory sessionFactory;
	
	/**
	 * This Method is responsible for SessionFactory built.
	 * @return Is SessionFactory built.
	 */	
	public static SessionFactory getSessionFactory(){
				
		if(sessionFactory == null){
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}		
		return sessionFactory;
	}
	
}
