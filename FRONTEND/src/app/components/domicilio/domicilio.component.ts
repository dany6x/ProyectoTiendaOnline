import { Component, OnInit } from '@angular/core'; 
//Importar para formularios
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
//Importar el servicio de DomicilioService
import { DomicilioService } from 'src/app/services/domicilio/domicilio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-domicilio',
  templateUrl: './domicilio.component.html',
  styleUrls: ['./domicilio.component.css']
})
export class DomicilioComponent implements OnInit {

  //Variables
  domicilioForm: FormGroup
  domicilios: any

  //constructor
  constructor(
    public fb: FormBuilder,
    public domicilioService: DomicilioService,

  ) {

  }
  ngOnInit(): void {
    this.domicilioForm = this.fb.group({
      id_domicilio: [''],
      calle: ['', Validators.required],
      numeroInterior: ['', Validators.required],
      numeroExterior: ['', Validators.required],
      codigoPostal: ['', [Validators.required, Validators.pattern(/^[0-9]{5}$/)]], //Validar 10 digitos,
      municipio: ['', Validators.required],
      colonia: ['', Validators.required],
      ciudad: ['', Validators.required],
      calle2: ['', Validators.required],
      calle3: ['', Validators.required],
      numeroContacto: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]], //Validar 10 digitos
      referencias: ['', Validators.required],

    });;
    //LISTAR TODOS LOS USUARIOS
    this.domicilioService.getAllDomicilios().subscribe(resp => {
      this.domicilios = resp;
    },
      error => { console.error(error) }
    );


  }


  //GUARDAR DOMICILIO
  guardar(): void {
    this.domicilioService.saveDomicilio(this.domicilioForm.value).subscribe(
      resp => {
        // Lógica adicional después de guardar el domicilio (opcional)
        //Resetear el formulario
        this.domicilioForm.reset();
        this.domicilioForm.setErrors(null);

        //ESTO AL PARECER NO FUNCIONA, VERIFICARLO....
        //limpiar la lista de usuarios registrados
        this.domicilios = this.domicilios.filter((domicilio: { id_domicilio: any; }) => resp.id_domicilio != domicilio.id_domicilio);
        //Hacer de forma reactiva que aparezca en la tabla cuando se registre
        this.domicilios.push(resp);

        //ACTIVAR EL BOTON DE REGISTRAR DOMICILIO
        //this.botonRegistrarPresionado = true;


        //MOSTRAR MENSAJE DE REGISTRO EXITOSO
        this.showSuccessAlert();



      },
      error => console.error(error)
    )
  }

  //ELIMINAR DOMICILIO POR id
  eliminar(domicilio: any) {
    this.domicilioService.deleteDomicilio(domicilio.id_domicilio).subscribe(resp => {
      console.log(resp)
      //si se elimina mostrar
      if (resp == true) {
        this.domicilios.pop(domicilio)
      }
    })
  }

  editar(domicilio: any) {
    this.domicilioForm.setValue({
      id_domicilio: domicilio.id_domicilio,
      calle: domicilio.calle,
      numeroInterior: domicilio.numeroInterior,
      numeroExterior: domicilio.numeroExterior,
      codigoPostal: domicilio.codigoPostal,
      municipio: domicilio.municipio,
      colonia: domicilio.colonia,
      ciudad: domicilio.ciudad,
      calle2: domicilio.calle2,
      calle3: domicilio.calle3,
      numeroContacto: domicilio.numeroContacto,
      referencias: domicilio.referencias,


    })
  }



  //Para mostrar mensaje de registro exitoso
  showSuccessAlert(): void {
    Swal.fire(
      'Domicilio registado con éxito',
      '',
      'success'
    )
  }

}
