import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  login() {
    // Aquí puedes agregar la lógica de autenticación
    // Por ejemplo, puedes hacer una solicitud HTTP para verificar las credenciales

    // Ejemplo básico de verificación de credenciales
    if (this.username === 'admin' && this.password === 'password') {
      alert('¡Inicio de sesión exitoso!');
    } else {
      alert('Credenciales inválidas. Por favor, inténtalo de nuevo.');
    }

    // Puedes redirigir a otra página después del inicio de sesión exitoso utilizando el enrutador de Angular
    // Por ejemplo, si tienes una ruta 'home', puedes usar: this.router.navigate(['/home']);
  }
}