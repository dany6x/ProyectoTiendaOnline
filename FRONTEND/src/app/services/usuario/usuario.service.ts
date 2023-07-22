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

  //Constructor del HttClient
  constructor(private httpClient: HttpClient) { }

  //Método para GUARDAR un usuario
  //recibe 2 parametros que es url y el usuario
  public saveUsuario(usuario: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER, usuario);
  }

  //Método para LISTAR todos los usuarios
  public getAllUsuarios(): Observable<any> {
    return this.httpClient.get(this.API_SERVER);
  }













}