package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

//Especificar que esta clase funcionará como servicio
@Service
public class UsuarioService {
	@Autowired 
	//qualifier para especificar la clase a inyectar
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	//Constructor para inicializar Repositorio
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository =usuarioRepository;
	}
	
	
	
	//GUARDAR USUARIO Y ACTUALIZAR
	public ResponseEntity<Object> guardarUsuario( UsuarioDTO usuarioDto) {	
		
		//Para verificar si hay un usuario con ese correo
		Optional<Usuario> res = usuarioRepository.findUsuarioByEmail(usuarioDto.getEmail());
		
		//Mostrar mensaje con pares clave-valor
		HashMap<String,Object> mensaje =new HashMap <>();
		
		
		if (res.isPresent() && usuarioDto.getId_usuario()==null ) {
			
			//Mostrar mensaje de que ya existe un usuario con ese email
			mensaje.put("error", true);
			mensaje.put("message","Ya existe un usuario con ese email");
			
			return new ResponseEntity<>(mensaje,HttpStatus.CONFLICT );
			
		}
		
		//Agregar al mensaje que se registró correctamente
		mensaje.put("message","Se registró usuario correctamente");
		
		//ACTUALIZAR USUARIO		
		//Si llega el id sería para actualizar el usuario
		if(usuarioDto.getId_usuario() !=null) {
			mensaje.put("message","Se actualizó usuario correctamente");
		}
		
		//Nuevo objeto tipo Usuario
		Usuario usuario= new Usuario ();
		
		//Guardar el objeto usuario en el repositorio
		usuario.setId_usuario(usuarioDto.getId_usuario() );
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido_paterno(usuarioDto.getApellido_paterno());
		usuario.setApellido_materno(usuarioDto.getApellido_materno());
		usuario.setFecha_nacimiento(usuarioDto.getFecha_nacimiento());
		usuario.setTelefono(usuarioDto.getTelefono());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setPassword(usuarioDto.getPassword());
		
		//Guardar Usuario
		usuarioRepository.save(usuario);
		
		//Mostrar mensaje de que se registró el usuario correctamente
		mensaje.put("datos", usuario);
		
		//Regresar respuesta con mensaje final
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED );
		
	}		
	
	
	//OBTENER USUARIO POR id
	public Usuario obtenerporID(Integer id_usuario) {
		//Llama al metodo definido findById
		return this.usuarioRepository.findById(id_usuario).get();
			
		}
			
	
	// ELIMINAR UN USUARIO POR id
		 
	public void  borrar_por_id( Integer id){	
		//Llama al metodo definido deleteByID
		usuarioRepository.deleteById(id);
		  
		  }
	 	
	
	//LISTAR TODOS LOS USUARIOS
	
	public List<Usuario> listarUsuarios (){
		//Llama al metodo definido findAll
		return usuarioRepository.findAll();
	}	
	
}
