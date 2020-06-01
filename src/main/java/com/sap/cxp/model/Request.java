package com.sap.cxp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
 
/****************************************************************************************************
*FECHA DE CREACIÓN: 27 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para las variables de entrada del web services.
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  V.1.0.1
******************************************************************************************************/

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Request 
{    
	@XmlAttribute(name="usuario", required=true) 
	private String usuario;
	
	@XmlAttribute(name="contrasena", required=true) 
	private String contrasena;
	
	@XmlElement(name="idTransaccion", required=true) 
	private String idTransaccion;
	
	@XmlElement(name="documentoContable", required=true) 
	private String documentoContable;
	
	@XmlElement(name="numCheque", required=true) 
	private String numCheque; 
	
	@XmlElement(name="fechaContable", required=true) 
	private String fechaContable;
	
	@XmlElement(name="horaContable", required=true) 
	private String horaContable;
	
	@XmlElement(name="codigoError", required=true) 
	private String codigoError;
	
	@XmlElement(name="mensajeError", required=true) 
	private String mensajeError;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	} 

	public String getDocumentoContable() {
		return documentoContable;
	}

	public void setDocumentoContable(String documentoContable) {
		this.documentoContable = documentoContable;
	}

	public String getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}

	public String getFechaContable() {
		return fechaContable;
	}

	public void setFechaContable(String fechaContable) {
		this.fechaContable = fechaContable;
	}

	public String getHoraContable() {
		return horaContable;
	}

	public void setHoraContable(String horaContable) {
		this.horaContable = horaContable;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String toString() {
		return "Request [id=" + idTransaccion + ", docConta=" + documentoContable + ", nCheque="
				+ numCheque + ", fCont=" + fechaContable + ", hCont=" + horaContable + ", codigoError="
				+ codigoError + ", mensaje=" + mensajeError + "]";
	}
	
	
	 
	 
	
	
	
	 
	 
	 
	
	 
	
	

}
