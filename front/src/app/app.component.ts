import { Component } from '@angular/core';
import { ClienteService } from './services/cliente.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';

  constructor(
    private _clienteService : ClienteService
  ) {}

  ngOnInit() {
    this._clienteService.getAll()
      .subscribe( function(response) {
        console.log(response);
      })
  }
}
