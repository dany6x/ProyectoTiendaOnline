import { Injectable } from '@angular/core';

//importaciones para conexion con backend
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  //url del API
  private API_SERVER = 'http://localhost:9090/guardarUsuarioDTO'
  private API_SERVER2 = 'http://localhost:9090/listarUsuarios'
  private API_SERVER3 = 'http://localhost:9090/borrarUsuario/'

  //Constructor del HttpClient
  constructor(private httpClient: HttpClient) { }



  //Método para GUARDAR un usuario
  //recibe 2 parametros que es url y el usuario
  public saveUsuario(usuario: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER, usuario);
  }

  //Método para LISTAR todos los usuarios
  public getAllUsuarios(): Observable<any> {
    return this.httpClient.get(this.API_SERVER2);
  }

  //Método para ELIMINAR un usuario
  public deleteUsuario(id_usuario: any): Observable<any> {
    return this.httpClient.delete(this.API_SERVER3 + id_usuario);
  }

  //Método para OBTENER un usuario por id


  //Método para ACTUALIZAR un usuario













}
