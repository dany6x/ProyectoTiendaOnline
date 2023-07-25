package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Domicilio;



public interface DomicilioRepository extends JpaRepository <Domicilio, Integer> {
	
	//Código opcional para validaciones
	//Buscar usuario a través de correo electrónico
	
//	Optional<Domicilio> findDomicilioByCalleAndNumero_interiorAndNumero_exteriorAndCodigo_postalAndMunicipioAndColoniaAndCiudadAndCalle_2AndCalle_3AndNumero_contactoAndReferencias(String calle, String numero_interior,
//			String numero_exterior, String codigo_postal, String municipio,String colonia, String ciudad, String calle_2, String calle_3, 
//			String numero_contacto, String referencias );
	
//	Optional<Domicilio> findByCalleAndNumeroInteriorAndNumeroExteriorAndCodigoPostalAndMunicipioAndColoniaAndCiudadAndCalle2AndCalle3AndNumeroContactoAndReferencias(
//            String calle, String numeroInterior, String numeroExterior, String codigoPostal, String municipio,
 //           String colonia, String ciudad, String calle2, String calle3, String numeroContacto, String referencias);
	
	 //Optional<Domicilio> findByCalleAndNumero_interiorAndNumeroExteriorAndCodigoPostalAndMunicipioAndColoniaAndCiudadAndCalle2AndCalle3AndNumeroContactoAndReferencias(
	            //@Param("calle") String calle,
	           // @Param("numero_interior") String numeroInterior,
	           // @Param("numero_exterior") String numeroExterior,
	           // @Param("codigo_postal") String codigoPostal,
	           // @Param("municipio") String municipio,
	           // @Param("colonia") String colonia,
	           // @Param("ciudad") String ciudad,
	           // @Param("calle_2") String calle2,
	          //  @Param("calle_3") String calle3,
	          //  @Param("numero_contacto") String numeroContacto,
	          //  @Param("referencias") String referencias
			 
			 
	  //  );
	
//	Optional<Domicilio> findDomicilioByCalleAndNumeroInteriorAndNumero_ExteriorAndCodigo_postalAndMunicipioAndColoniaAndCiudadAndCalle_2AndCalle_3AndNumero_contactoAndReferencias(String calle, String numero_interior, String numero_exterior, String codigo_postal, String municipio,String colonia, String ciudad, String calle_2, String calle_3, 
//	String numero_contacto, String referencias );

	Optional<Domicilio> findDomicilioByCalleAndNumeroInteriorAndNumeroExteriorAndCodigoPostalAndMunicipioAndColoniaAndCiudadAndCalle2AndCalle3AndNumeroContactoAndReferencias(String calle, String numeroInterior,
			String numero_exterior, String codigo_postal, String municipio,String colonia, String ciudad, String calle_2, String calle_3, 
			String numero_contacto, String referencias 
            
		 
		 
    ); 

	
	
	
	
	

}
