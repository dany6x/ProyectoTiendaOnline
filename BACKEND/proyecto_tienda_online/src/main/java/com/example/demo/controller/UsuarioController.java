package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

//Indicar que esta clase va a servir para recibir peticiones del cliente 
@RestController

public class UsuarioController {
	
	//Inyectar como dependencia el servicio al controlador con autowired
	@Autowired
	public UsuarioService usuarioService;
	
		
	//GUARDAR USUARIO
	@PostMapping ("/guardarUsuarioDTO")
	public ResponseEntity<Object> guardarUsuario(@RequestBody UsuarioDTO usuarioDto) {
				
		try {
			return usuarioService.guardarUsuario(usuarioDto);
			
		} catch(Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
	
	//OBTENER USUARIO A TRAVÉS DEL id (GET)
	/**
	 * @param id
	 * @return
	 */
	@GetMapping ("/obtenerUsuarioDTO/{id_usuario}")
	
	//retorna objeto que puede ser los datos del usuario o mensaje de error
	public ResponseEntity<Object> obtenerUsuario(@PathVariable("id_usuario") Integer id_usuario){
		
		try {
			Usuario usuario= this.usuarioService.obtenerporID(id_usuario);
			
			//mandar los datos a traves del DataDTO
			UsuarioDTO datos= new UsuarioDTO(usuario);
			
			//retornar el estatus como respuesta asumiendo que la petición es positiva
			//return new ResponseEntity<>(datos,HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.OK).body(datos);
		} catch(Exception e) {
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Usuario no encontrado");
			
		}
		
	  }	

	
	
	//ELIMINAR USUARIO POR id
		@DeleteMapping ("/borrarUsuario/{id}")

		private ResponseEntity <String> borrarUsuario (@PathVariable("id") Integer id) {
			try {
				usuarioService.borrar_por_id (id);
				return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");
				//return ResponseEntity.ok().build();
			} catch(Exception e) {
				//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Usuario no encontrado");
			}

		}	
	
	//LISTAR TODOS LOS USUARIOS
		
	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		
		//Crear lista vacia
		List<Usuario> respuesta=null; 
		
		try {
			respuesta =usuarioService.listarUsuarios();
			return ResponseEntity.ok().body(respuesta);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 			
		}
		
	}
	
}
	


