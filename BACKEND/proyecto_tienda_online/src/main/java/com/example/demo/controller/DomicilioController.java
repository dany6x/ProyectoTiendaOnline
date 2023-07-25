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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.entity.Domicilio;
import com.example.demo.service.DomicilioService;

//Indicar que esta clase va a servir para recibir peticiones del cliente 
@RestController

public class DomicilioController {
	
	//Inyectar como dependencia el servicio al controlador con autowired
	@Autowired
	public DomicilioService domicilioService;
	
		
	//GUARDAR DOMICILIO
	@PostMapping ("/guardarDomicilioDTO")
	public ResponseEntity<Object> guardarDomicilio(@RequestBody DomicilioDTO domicilioDto) {
				
		try {
			return domicilioService.guardarDomicilio(domicilioDto);
			
		} catch(Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
	
	//OBTENER DOMICILIO A TRAVÉS DEL id (GET)
	/**
	 * @param id
	 * @return
	 */
	@GetMapping ("/obtenerDomicilioDTO/{id_domicilio}")
	
	//retorna objeto que puede ser los datos del domicilio o mensaje de error
	public ResponseEntity<Object> obtenerDomicilio(@PathVariable("id_domicilio") Integer id_domicilio){
		
		try {
			Domicilio domicilio= this.domicilioService.obtenerporID(id_domicilio);
			
			//mandar los datos a traves del DataDTO
			DomicilioDTO datos= new DomicilioDTO(domicilio);
			
			//retornar el estatus como respuesta asumiendo que la petición es positiva
			return ResponseEntity.status(HttpStatus.OK).body(datos);
		} catch(Exception e) {
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Domicilio no encontrado");
			
		}
		
	  }	
	
	
	//ACTUALIZAR Domicilio - Usa el mismo método que guardar 
		@PutMapping("/actualizarDomicilioDTO")
		public ResponseEntity<Object>actualizarDomicilio(@RequestBody DomicilioDTO domicilioDto){
			try {
				return domicilioService.guardarDomicilio(domicilioDto);
				
			} catch(Exception e) {
				//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Domicilio no encontrado");
			}
		}
		
	
	
	//ELIMINAR DOMICILIO POR id
		@DeleteMapping ("/borrarDomicilio/{id}")

		private ResponseEntity <String> borrarUsuario (@PathVariable("id") Integer id) {
			try {
				domicilioService.borrar_por_id (id);
				return ResponseEntity.status(HttpStatus.OK).body("Domicilio eliminado correctamente");
				//return ResponseEntity.ok().build();
			} catch(Exception e) {
				//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Domicilio no encontrado");
			}

		}	
	
	//LISTAR TODOS LOS DOMICILIOS
		
	@GetMapping("/listarDomicilios")
	public ResponseEntity<List<Domicilio>> listarDomicilios(){
		
		//Crear lista vacia
		List<Domicilio> respuesta=null; 
		
		try {
			respuesta = domicilioService.listarDomicilios();
			return ResponseEntity.ok().body(respuesta);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 			
		}
		
	}
	
	
	

}
