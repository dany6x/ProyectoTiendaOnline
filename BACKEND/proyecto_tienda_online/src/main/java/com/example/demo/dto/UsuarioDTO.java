package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entity.Usuario;

//Serializable para enviar y recibir por red
public class UsuarioDTO implements Serializable {
		
	/**
	 * Para versiones
	 */
	private static final long serialVersionUID = 1L;	
	
	//Agregar los atributos del usuario que se van a ocupar, se pueden agregar/ quitar algunos 
	public Integer id_usuario;
	public String nombre;
	public String apellido_paterno;
	public String apellido_materno;
	public java.sql.Date fecha_nacimiento;
	public String telefono;
	public String email;
	public String password; //se puede quitar
	
	
	//constructor vacio
	public UsuarioDTO() {
		
	}
	
	//constructor que reciba como parametro a Usuario
	public UsuarioDTO(Usuario usuario) {
		//Hacer asignacion de los datos de Usuario hacia DTO
		this.id_usuario = usuario.getId_usuario();
		this.nombre=usuario.getNombre();
		this.apellido_paterno= usuario.getApellido_paterno();
		this.apellido_materno = usuario.getApellido_materno();
		this.fecha_nacimiento= usuario.getFecha_nacimiento();
		this.telefono =usuario.getTelefono();
		this.email=usuario.getEmail();
		this.password=usuario.getPassword();	//se puede quitar	
		
	}

	
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
