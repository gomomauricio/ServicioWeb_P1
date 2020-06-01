package com.sap.cxp.model;

/****************************************************************************************************
*FECHA DE CREACIÓN: 27 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para las variables de respuesta del web services.
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón V.1.0.1
******************************************************************************************************/

public class Response 
{ 
	private Integer  codigo_error;   //codigoError  
	private String descripcion_error;  //ErrorInformacion 
	
	
	public Integer getCodigo_error() {
		return codigo_error;
	}
	public void setCodigo_error(Integer codigo_error) {
		this.codigo_error = codigo_error;
	}
	public String getDescripcion_error() {
		return descripcion_error;
	}
	public void setDescripcion_error(String descripcion_error) {
		this.descripcion_error = descripcion_error;
	}
	@Override
	public String toString() {
		return "Response [codigo_error=" + codigo_error + ", descripcion_error=" + descripcion_error + "]";
	}
	 
	
      
	
	
	
	 
      
}
