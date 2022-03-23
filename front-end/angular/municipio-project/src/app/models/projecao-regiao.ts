import { IncrementoRegiao } from './incremento-regiao';
export class ProjecaoRegiao {
  populacao?: number;
  periodoMedio?: IncrementoRegiao[];

  constructor(object: Partial<ProjecaoRegiao>)
  {
    Object.assign(this, object);
  }
}
