package com.example.demo.dto;

import java.io.Serializable;



import com.example.demo.entity.Domicilio;


//Serializable para enviar y recibir por red
public class DomicilioDTO implements Serializable {

	/**
	 * Para versiones
	 */
	private static final long serialVersionUID = 1L;	
	
	//Agregar los atributos del usuario que se van a ocupar, se pueden agregar/ quitar algunos 
	public Integer id_domicilio;
	public String calle;
	public String numeroInterior;
	public String numeroExterior;
	public String codigoPostal;
	public String municipio;
	public String colonia; 
	public String ciudad; 
	public String calle2; 
	public String calle3; 
	public String numeroContacto; 
	public String referencias; 
	
	//constructor vacio (No borrar, es necesario)
	public DomicilioDTO() {
		
	}
	
	//constructor que reciba como parametro a Domicilio
	public DomicilioDTO(Domicilio domicilio) {
		
		//Hacer asignacion de los datos de Domicilio hacia DTO
		this.id_domicilio = domicilio.getId_domicilio();
		this.calle = domicilio.getCalle();
		this.numeroInterior = domicilio.getNumeroInterior();
		this.numeroExterior = domicilio.getNumeroExterior();
		this.codigoPostal = domicilio.getCodigoPostal();
		this.municipio = domicilio.getMunicipio();
		this.colonia = domicilio.getColonia();
		this.ciudad = domicilio.getCiudad();
		this.calle2 = domicilio.getCalle2();
		this.calle3 = domicilio.getCalle3();
		this.numeroContacto = domicilio.getNumeroContacto();
		this.referencias = domicilio.getReferencias();

	}


	
	//GETTERS Y SETTERS
	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public String getCalle3() {
		return calle3;
	}

	public void setCalle3(String calle3) {
		this.calle3 = calle3;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	
	
	
}
