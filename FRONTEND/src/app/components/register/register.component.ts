import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from 'src/app/services/usuario/usuario.service'; // Asegúrate de que la ruta al servicio sea correcta

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  usuarioForm: FormGroup;

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuarioService
  ) { }

  ngOnInit(): void {
    this.usuarioForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido_paterno: ['', Validators.required],
      apellido_materno: ['', Validators.required],
      fecha_nacimiento: ['', Validators.required],
      telefono: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  guardar(): void {
    this.usuarioService.saveUsuario(this.usuarioForm.value).subscribe(
      resp => {
        // Lógica adicional después de guardar el usuario (opcional)
      },
      error => console.error(error)
    );
  }
}