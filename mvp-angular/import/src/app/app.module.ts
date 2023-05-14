import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarModuloModule } from 'navbar-prova/src/app/navbar-modulo/navbar-modulo.module';

@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    NavbarModuloModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
