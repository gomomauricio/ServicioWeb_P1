package com.sap.cxp.dao;

import java.sql.Connection;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class DBGenericDAO {		
	
	@Autowired
   @Qualifier("DBSessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;    
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;    
    }
    
    public Connection getConnection() {
		return ((SessionImpl) (sessionFactory.getCurrentSession())).connection();
	}        
}
