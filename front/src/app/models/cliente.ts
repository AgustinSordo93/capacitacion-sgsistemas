import { Provincia } from './provincia';

export class Cliente {

    constructor(
        public id : number = null,
        public nombre : string = '',
        public apellido : string = '',
        public telefono : string = '',
        public provincia : Provincia = null
    ){}
}