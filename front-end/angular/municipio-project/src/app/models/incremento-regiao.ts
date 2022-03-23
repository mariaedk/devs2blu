export class IncrementoRegiao {
  incrementoPopulacional?: number;

  constructor(object: Partial<IncrementoRegiao>)
  {
    Object.assign(this, object);
  }
}
