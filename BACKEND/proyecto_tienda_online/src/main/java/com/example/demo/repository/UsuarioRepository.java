package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Usuario;

//Interface que va a heredar de la clase JpaRepository <Clase a relacionar con repositorio ,Tipo de ID que usaremos  >

//La clase JpaRepository ya tiene los métodos necesarios, por eso no se le agrega más

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
	
	//Buscar usuario a través de correo electrónico
	
	Optional<Usuario> findUsuarioByEmail(String email);
	

}
