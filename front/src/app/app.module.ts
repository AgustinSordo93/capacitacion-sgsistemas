import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
 
import { AppComponent } from './app.component';

import { ClienteService } from './services/cliente.service';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';

@NgModule({
  declarations: [
    AppComponent,
    ClienteFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ClienteService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
