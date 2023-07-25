package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Indicar que esta clase es una entidad con:
@Entity

//Indicar la tabla a la que hace referencia
@Table (name="domicilio", schema="public")

public class Domicilio {
	
	//Indicar que id va a trabajar como llave primaria
	@Id
	//Indicar el valor autoincrementable 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	//ATRIBUTOS
	@Column(name = "id_domicilio")
	private Integer id_domicilio;
	@Column(name = "calle")
	private String calle;
	@Column(name = "numero_interior")
	private String numeroInterior;
	@Column(name = "numero_exterior")
	private String numeroExterior;
	@Column(name = "codigo_postal")
	private String codigoPostal;
	@Column(name = "minucipio")
	private String municipio;
	@Column(name = "colonia")
	private String colonia;
	@Column(name = "ciudad")
	private String ciudad; 
	@Column(name = "calle_2")
	private String calle2; 
	@Column(name = "calle_3")
	private String calle3; 
	@Column(name = "numero_contacto")
	private String numeroContacto;
	@Column(name = "referencias")
	private String referencias;


	//campo unico para verificar antes de registrarlo
	//@Column (unique=true)
	//private String email;
		
	
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
	


}
