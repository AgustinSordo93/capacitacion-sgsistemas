import { Injectable } from '@angular/core';
import { Provincia } from '../models/provincia';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ProvinciaService {

    private _uri : string = 'http://localhost:8099/provincias';

    constructor(
        private _httpClient : HttpClient
    ) {}

    getAll() : Observable<Array<Provincia>> {
        return this._httpClient.get<Array<Provincia>>(this._uri);
    }

    getById(id : number) {
        return this._httpClient.get<Provincia>(this._uri + '/' + id);
    }

    save(provincia : Provincia) {
        return this._httpClient.post<Provincia>(this._uri, provincia);
    }

    delete(id : number) {
        return this._httpClient.delete<Provincia>(this._uri + '/' + id);
    }
}