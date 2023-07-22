import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
//import { DomicilioComponent } from './components/domicilio/domicilio.component';
//import { CarritoComponent } from './components/carrito/carrito.component';
//import { PagoComponent } from './components/pago/pago.component';
//import { TablaadminComponent } from './components/tablaadmin/tablaadmin.component';
//import { AgregarProductoComponent } from './components/agregar-producto/agregar-producto.component';
//import { EditarProductoComponent } from './components/editar-producto/editar-producto.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  //{ path: 'domicilio', component: DomicilioComponent },
  //{ path: 'carrito', component: CarritoComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  //{ path: 'pago', component: PagoComponent },
  //{ path: 'tablaadmin', component: TablaadminComponent },
  //{ path: 'agregar-producto', component: AgregarProductoComponent },
  //{ path: 'editar-producto', component: EditarProductoComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
