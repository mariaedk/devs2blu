export class ResponseLink {
  url?:string;

  constructor(object: Partial<ResponseLink>)
  {
    Object.assign(this, object);
  }
}
