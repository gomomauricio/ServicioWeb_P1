package com.sap.cxp.dao;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sap.cxp.service.DataBaseService;

/****************************************************************************************************
*FECHA DE CREACIÓN: 27 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para consumir SP de caracter general en la aplicacion.
*
**ULTIMA MODIFICACION FECHA:20/04/2020
*ULTIMA MODIFICACION DESCRIPCION:Se actualiza la tabla para hacer login.
*
*@author Mauricio González Mondragón V.1.0.1
******************************************************************************************************/

@Repository
public class UtilDAO extends DBGenericDAO  
{
	private static final Logger logger = Logger.getLogger(UtilDAO.class);
	
	public Integer isUsuarioValido(String user,String pass) 
	{ 
			Integer res = 0;   
			
			try
			{
				String consulta = "CALL spvalidausuario(7,'CXC',15,'" +	user + "','" + pass + "');" ;
				  
					 Query query = getSessionFactory().getCurrentSession()
							 						  .createSQLQuery( consulta );
					 
					 res =   ((BigDecimal)query.uniqueResult()).intValue();	  
			}
			catch (Exception e) 
			{
				logger.error("Ocurrio un error al procesar al verificar login" ,e);
				res = 0;
			}
			
			return res; 
		}
	
}
