package com.sap.cxp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
 
import com.sap.cxp.model.Request;
import com.sap.cxp.model.Response;
import com.sap.cxp.service.DataBaseService; 

/****************************************************************************************************
*FECHA DE CREACIÓN: 27 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para orquestar el servicio web con el SP: spCxPCD
*
*ULTIMA MODIFICACION FECHA:20/04/2020
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  V.1.0.1
******************************************************************************************************/

@Repository
public class CXP_DAO extends DBGenericDAO 
{
	private static final Logger logger = Logger.getLogger(DataBaseService.class);
	
	public Response setConfirmaDisp(Request re) 
	{
		Response response = new Response();  // respuesta del servicio web 
		 
			try
			{ 
					String consulta = "Call spCxPCD(" + re.getIdTransaccion() + ",'"+ 
							            						   re.getDocumentoContable() + "','" + 
							            						   re.getNumCheque() + "','" + 
							            						   re.getFechaContable() + "','" + 
							            						   re.getHoraContable() + "','" + 
							            						   re.getCodigoError() + "','" +
							            						   re.getMensajeError() + "' )" ;
	  
					Query query2 = getSessionFactory().getCurrentSession()
							                          .createSQLQuery( consulta );
						 
		 
						@SuppressWarnings("unchecked")
						Iterator<Object> i = query2.list().iterator();
						
						while (i.hasNext()) 
						{
							Object[] row = (Object[]) i.next();
							
							response.setCodigo_error((Integer)row[0]);  
							response.setDescripcion_error(row[3].toString());  
				        } 
				}
				catch (Exception e) 
				{ 
					response.setCodigo_error(-1);  
					response.setDescripcion_error("Error de comunicacion BD");  
					logger.error("al consultar SP spCxPCD " + e);
					e.printStackTrace();
				} 
		    logger.info("Temina SP spCxPCD " + response.getCodigo_error() + "-" + response.getDescripcion_error() );
			return response;
					
		} 
}
