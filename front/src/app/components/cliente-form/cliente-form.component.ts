import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {

  cliente : Cliente = new Cliente();

  clientes : Array<Cliente> = new Array<Cliente>();

  constructor(
    private _clienteService : ClienteService
  ) { }

  ngOnInit() {
    this.loadClientes()
  }

  loadClientes() {
    this._clienteService.getAll()
      .subscribe( (response : Array<Cliente> ) => {
        this.clientes = response;
      });
  }
  aceptar() {
    this._clienteService.save(this.cliente)
      .subscribe(response => {
        this.cliente = new Cliente();
        this.loadClientes();
      });
  }

  modificar(id : number) {
    this._clienteService.getById(id)
      .subscribe( (response : Cliente ) => {
        this.cliente = response;
      });
  }

}
