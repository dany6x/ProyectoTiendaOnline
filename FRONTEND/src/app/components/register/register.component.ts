import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from 'src/app/services/usuario/usuario.service'; // Asegúrate de que la ruta al servicio sea correcta

//importar libreria sweetalert2 para modals
import Swal from 'sweetalert2';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  //VARIABLES DEL COMPONENTE REGISTER
  usuarioForm: FormGroup;
  usuarios: any;
  usuario: any;

  // Variable para habilitar/deshabilitar el botón adicional
  botonRegistrarDomicilio: boolean = false;

  // Variable para habilitar/deshabilitar el botón "Registrar"
  //Si lo ponemos en falso aparecerá hasta dar click al boton registrar
  //Si lo ponemos en true aparece pero se habilita hasta dar click al boton registrar
  botonRegistrarPresionado: boolean = true;


  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuarioService
  ) { }


  ngOnInit(): void {
    this.usuarioForm = this.fb.group({
      id_usuario: [''],
      nombre: ['', Validators.required],
      apellido_paterno: ['', Validators.required],
      apellido_materno: ['', Validators.required],
      fecha_nacimiento: ['', Validators.required],
      telefono: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]], //Validar 10 digitos
      email: ['', [Validators.required, Validators.email]],  //Validación de formato email
      password: ['', Validators.required],
    });;

    //LISTAR TODOS LOS USUARIOS
    this.usuarioService.getAllUsuarios().subscribe(resp => {
      this.usuarios = resp;
    },
      error => { console.error(error) }
    );


  }


  //GUARDAR USUARIO
  guardar(): void {
    this.usuarioService.saveUsuario(this.usuarioForm.value).subscribe(
      resp => {
        // Lógica adicional después de guardar el usuario (opcional)
        //Resetear el formulario
        this.usuarioForm.reset();
        this.usuarioForm.setErrors(null);

        //ESTO AL PARECER NO FUNCIONA, VERIFICARLO....
        //limpiar la lista de usuarios registrados
        this.usuarios = this.usuarios.filter((usuario: { id_usuario: any; }) => resp.id_usuario != usuario.id_usuario);
        //Hacer de forma reactiva que aparezca en la tabla cuando se registre
        this.usuarios.push(resp);

        //ACTIVAR EL BOTON DE REGISTRAR DOMICILIO YEL DE REGISTRO
        this.botonRegistrarPresionado = true;
        this.botonRegistrarDomicilio = true;

        //MOSTRAR MENSAJE DE REGISTRO EXITOSO
        this.showSuccessAlert();



      },
      error => console.error(error)
    )
  }

  //ELIMINAR USUARIO POR id
  eliminar(usuario: any) {
    this.usuarioService.deleteUsuario(usuario.id_usuario).subscribe(resp => {
      console.log(resp)
      //si se elimina mostrar
      if (resp == true) {
        this.usuarios.pop(usuario)
      }
    })
  }

  editar(usuario: any) {
    this.usuarioForm.setValue({
      id_usuario: usuario.id_usuario,
      nombre: usuario.nombre,
      apellido_paterno: usuario.apellido_paterno,
      apellido_materno: usuario.apellido_materno,
      fecha_nacimiento: usuario.fecha_nacimiento,
      telefono: usuario.telefono,
      email: usuario.email,
      password: usuario.password,
    })
  }

  accionBotonAdicional() {
    // Lógica para lo que debe hacer el botón adicional al ser presionado
    // Direccionar a la pagina de registrar un domicilio
    console.log('Botón Adicional presionado');

  }



  //Para mostrar mensaje de registro exitoso
  showSuccessAlert(): void {
    Swal.fire(
      'Usuario registado con éxito',
      'Por favor, ahora registra un domicilio',
      'success'
    )
  }










}
