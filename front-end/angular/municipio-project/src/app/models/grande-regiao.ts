import { ProjecaoRegiao } from './projecao-regiao';
export class GrandeRegiao
{
  localidade?: number;
  horario?: '22/03/2022 21:10:24';
  projecao?: ProjecaoRegiao[];

  constructor(object: Partial<GrandeRegiao>)
  {
    Object.assign(this, object);
  }
}
