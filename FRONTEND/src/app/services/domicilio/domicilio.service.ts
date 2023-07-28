import { Injectable } from '@angular/core';

//importaciones para conexion con backend
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DomicilioService {

  //url del API
  private API_SERVER_GUARDAR_DOMICILIO = 'http://localhost:9090/guardarDomicilioDTO'
  private API_SERVER_LISTAR_DOMICILIOS = 'http://localhost:9090/listarDomicilios'
  private API_SERVER_BORRAR_DOMICILIO = 'http://localhost:9090/borrarDomicilio/'

  //Constructor del HttpClient
  constructor(private httpClient: HttpClient) { }



  //Método para GUARDAR un usuario
  //recibe 2 parametros que es url y el usuario
  public saveDomicilio(domicilio: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER_GUARDAR_DOMICILIO, domicilio);
  }

  //Método para LISTAR todos los domicilioos
  public getAllDomicilios(): Observable<any> {
    return this.httpClient.get(this.API_SERVER_LISTAR_DOMICILIOS);
  }

  //Método para ELIMINAR un domicilio
  public deleteDomicilio(id_domicilio: any): Observable<any> {
    return this.httpClient.delete(this.API_SERVER_BORRAR_DOMICILIO + id_domicilio);
  }

  //Método para OBTENER un domicilio por id


  //Método para ACTUALIZAR un domicilio


}
 
