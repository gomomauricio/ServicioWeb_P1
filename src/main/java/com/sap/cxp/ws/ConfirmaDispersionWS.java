package com.sap.cxp.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.cxp.model.Request;
import com.sap.cxp.model.Response;
import com.sap.cxp.service.DataBaseService;

/****************************************************************************************************
*FECHA DE CREACIÓN: 12 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para crear la firma del servicio web
*
*ULTIMA MODIFICACION FECHA:19/03/2020
*ULTIMA MODIFICACION DESCRIPCION:Se actualizan las entradas del webservices.
*
*@author Mauricio González Mondragón  V.1.0.1
******************************************************************************************************/

@WebService
@Component("ConfirmaDispersionWS")
public class ConfirmaDispersionWS 
{
	private static final Logger logger = Logger.getLogger(DataBaseService.class);
	
	@Autowired
	DataBaseService sigsService;
	
	@Resource
    WebServiceContext context;
	
	@WebMethod
	@WebResult(name = "CXP") 
	public Response confirmarDispersion(@WebParam(name = "WS_CXP") @XmlElement(required = true)  Request req )
	{
		//////////////////
		Response res = new Response(); 
		
//		System.out.println("Entra bien");
		
		if( isAuthenticated(req.getUsuario(), req.getContrasena()) )
		{ 
			try
			{
				
				if(revisarRequest(req))
				{
					logger.error("Ocurrio un error al procesar la solicitud:"  + req);
					res.setCodigo_error(-1);  
					res.setDescripcion_error("Revisar xml contine registros con caracteres especiales o vacios.");
				}
				else
				{
					res = sigsService.setConfirmaDisp(req);
				} 
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				logger.error("Ocurrio un error al procesar la solicitud:"  + res.toString());
				res.setCodigo_error(-1);  
				res.setDescripcion_error("Error de comunicacion BD");   
			}
		}
		else
		{ 
			res.setCodigo_error(-1);  
			res.setDescripcion_error("Credenciales no validas"); 
		}
	  
		return res;
	}
	
	
	private Boolean revisarRequest(Request req)
	{
		Boolean isVacio = false;
		
		if(req.getIdTransaccion().contains("?") || req.getIdTransaccion().equals("")) isVacio = true;
		if(req.getDocumentoContable().contains("?") || req.getDocumentoContable().equals("")) isVacio = true;
		if(req.getNumCheque().contains("?") || req.getNumCheque().equals("")) isVacio = true;
		if(req.getFechaContable().contains("?") || req.getFechaContable().equals("")) isVacio = true;
		if(req.getHoraContable().contains("?") || req.getHoraContable().equals("")) isVacio = true;
		if(req.getCodigoError().contains("?") || req.getCodigoError().equals("")) isVacio = true;
		if(req.getMensajeError().contains("?") || req.getMensajeError().equals("")) isVacio = true; 
//		System.out.println(" isOK " + isVacio);
		return isVacio;
	}
	
	
	 
	
	private boolean isAuthenticated(String user, String pass) 
	{ 
	    Boolean res = false; 
	    System.out.println("Entra con; " + user + " - " + pass);
	    try
	    { 
	    	if( !user.isEmpty() && !pass.isEmpty() )
		    {
	    		if ( sigsService.isUserOk(user, pass) >= 1 )
			    		 res = true; 
				else
				 		 res = false;  
		    } System.out.println(" sale con res= " + res);
	    }
	    catch (Exception e) 
	    {
			res = false; 
			 logger.error("Error al buscar login Usuario " , e);
			e.printStackTrace();
		}
	    

	   return res;
	}
 
}
