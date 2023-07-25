package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.entity.Domicilio;
import com.example.demo.repository.DomicilioRepository;


//Especificar que esta clase funcionará como servicio
@Service

public class DomicilioService {
	
	@Autowired 
	//qualifier para especificar la clase a inyectar
	@Qualifier("domicilioRepository")
	private DomicilioRepository domicilioRepository;
	
	//Constructor para inicializar Repositorio
	public DomicilioService(DomicilioRepository domicilioRepository) {
		this.domicilioRepository = domicilioRepository;
	}
	
	//GUARDAR DOMICILIO Y ACTUALIZAR
	public ResponseEntity<Object> guardarDomicilio( DomicilioDTO domicilioDto) {	
		
		//Variale tipo Domicilio que almacenará todos los campos de domicilio
		Optional<Domicilio> res = domicilioRepository.findDomicilioByCalleAndNumeroInteriorAndNumeroExteriorAndCodigoPostalAndMunicipioAndColoniaAndCiudadAndCalle2AndCalle3AndNumeroContactoAndReferencias(domicilioDto.getCalle() , domicilioDto.getNumeroInterior(),domicilioDto.getNumeroExterior(),
				domicilioDto.getCodigoPostal() , domicilioDto.getMunicipio() ,
				domicilioDto.getColonia() , domicilioDto.getCiudad() , domicilioDto.getCalle2(),
				domicilioDto.getCalle3(), domicilioDto.getNumeroContacto(), domicilioDto.getReferencias() );
		
		//Mostrar mensaje con pares clave-valor
		HashMap<String,Object> mensaje =new HashMap <>();
		
		//Compara todo el objeto domicilio recibido para verificar si ya existe		
		if ( res.isPresent()  && domicilioDto.getId_domicilio() ==null ) {
			
			//Mostrar mensaje de que ya existe un domicilio con ese email
			mensaje.put("error", true);
			mensaje.put("message","Ya existe un domicilio igual registrado");
			
			return new ResponseEntity<>(mensaje,HttpStatus.CONFLICT );
			
		}		
		
		//Agregar al mensaje que se registró correctamente
		mensaje.put("message","Se registró domicilio correctamente");
				
		
		
		//ACTUALIZAR DOMICILIO
		
		//Para verificar si el repositorio no está vacío y se quiere actualizar un domicilio y se cambian los mensajes
		if (res.isPresent()==false  && domicilioDto.getId_domicilio() !=null && domicilioRepository.count()==0   ) {
			mensaje.put("error", true);
			mensaje.put("message","Domicilio no encontrado");
			
			return new ResponseEntity<>(mensaje,HttpStatus.CONFLICT );
		}		
		
		//Si llega el id sería para actualizar el domicilio. Ya no es necesario verificar si el repositorio está vacío por lo anterior
		// se cambian los mensajes
		if(domicilioDto.getId_domicilio()  !=null ) {
			mensaje.put("message","Se actualizó domicilio correctamente");
		}
		
		
		//SI no entra a ninguno de los if anteriores, significa que se creará un nuevo Domicilio
		//Nuevo objeto tipo Domicilio
		Domicilio domicilio= new Domicilio ();
		
		//Guardar el objeto domicilio en el repositorio
		domicilio.setId_domicilio(domicilioDto.getId_domicilio());;
		domicilio.setCalle(domicilioDto.getCalle());
		domicilio.setNumeroInterior(domicilioDto.getNumeroInterior());
		domicilio.setNumeroExterior(domicilioDto.getNumeroExterior());
		domicilio.setCodigoPostal(domicilioDto.getCodigoPostal());
		domicilio.setMunicipio(domicilioDto.getMunicipio());
		domicilio.setColonia(domicilioDto.getColonia());
		domicilio.setCiudad(domicilioDto.getCiudad());
		domicilio.setCalle2(domicilioDto.getCalle2());
		domicilio.setCalle3(domicilioDto.getCalle3());
		domicilio.setNumeroContacto(domicilioDto.getNumeroContacto());
		domicilio.setReferencias(domicilioDto.getReferencias());
		
		
		//Guardar Usuario
		domicilioRepository.save(domicilio);
		
		//Mostrar mensaje de que se registró el usuario correctamente
		mensaje.put("datos", domicilio);
		
		//Regresar respuesta con mensaje final
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED );
		
	}		
	
	

	//OBTENER DOMICILIO POR id
	public Domicilio obtenerporID(Integer id_domicilio) {
		//Llama al metodo definido findById
		return this.domicilioRepository.findById(id_domicilio).get();
			
		}
			
	
	// ELIMINAR UN DOMICILIO POR id
		 
	public void  borrar_por_id( Integer id){	
		//Llama al metodo definido deleteByID
		domicilioRepository.deleteById(id);
		  
		  }
	 	
	
	//LISTAR TODOS LOS DOMICILIOS
	
	public List<Domicilio> listarDomicilios (){
		//Llama al metodo definido findAll
		return domicilioRepository.findAll();
	}	
	
	
	


}
