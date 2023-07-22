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
@Table (name="usuario", schema="public")

public class Usuario {
	
	//Indicar que id va a trabajar como llave primaria
	@Id
	//Indicar el valor autoincrementable 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id_usuario;
	
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private java.sql.Date fecha_nacimiento;
	private String telefono;
	//campo unico para verificar antes de registrarlo
	@Column (unique=true)
	private String email;
	
	private String password;
	
	
	
	//GETTERS Y SETTERS
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public java.sql.Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(java.sql.Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	 
	

}
