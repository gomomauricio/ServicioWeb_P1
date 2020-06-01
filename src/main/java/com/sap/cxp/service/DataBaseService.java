package com.sap.cxp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.cxp.dao.CXP_DAO;
import com.sap.cxp.dao.UtilDAO;
import com.sap.cxp.model.Request;
import com.sap.cxp.model.Response; 
 

/**************************************************************************************************** 

******************************************************************************************************/


@Service
public class DataBaseService {
	private static final Logger logger = Logger.getLogger(DataBaseService.class);

	@Autowired
	CXP_DAO obtenerPoliza; 
	
	@Autowired
	UtilDAO utilDAO;
	
	@Transactional (value="DBTxManager", readOnly = true)
	public Response setConfirmaDisp(Request re) 
	{ 
		return obtenerPoliza.setConfirmaDisp(re);
	} 
	
	@Transactional (value="DBTxManager", readOnly = true)
	public Integer isUserOk(String user,String pass) 
	{
		return utilDAO.isUsuarioValido(user, pass);	
	}
	
	 
	 
	 
	 
}
