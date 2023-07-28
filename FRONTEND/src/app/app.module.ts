import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//COMPONENTES AGREGADOS
import { NavbarComponent } from './components/navbar/navbar.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';


import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { HttpClientModule } from '@angular/common/http';
import { AgregarProductoComponent } from './components/agregar-producto/agregar-producto.component';
import { CarritoComponent } from './components/carrito/carrito.component';
import { DomicilioComponent } from './components/domicilio/domicilio.component';
import { EditarProductoComponent } from './components/editar-producto/editar-producto.component';
import { PagoComponent } from './components/pago/pago.component';
import { TablaadminComponent } from './components/tablaadmin/tablaadmin.component'


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AgregarProductoComponent,
    CarritoComponent,
    DomicilioComponent,
    EditarProductoComponent,
    PagoComponent,
    TablaadminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule, // Asegúrate de que esté importado
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
