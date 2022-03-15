import { EstadoIbge } from './estado-ibge';
export class CidadeIbge {
  id?:string;
  nome?:string;
  microrregiao?: MicroRegiao;

  // construir objeto
  constructor(obj: Partial<CidadeIbge>)
  {
    Object.assign(this, obj);
  }
}

export class MicroRegiao {
  id?:number;
  nome?:string;
  mesorregiao?:Mesorregiao;

  constructor(obj: Partial<MicroRegiao>)
  {
    Object.assign(this, obj);
  }
}

export class Mesorregiao
{
  id?:number;
  nome?:string;
  UF?: EstadoIbge;

  constructor(obj: Partial<Mesorregiao>)
  {
    Object.assign(this, obj);
  }
}

