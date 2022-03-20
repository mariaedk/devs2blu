
export class Animal {
  name?: string;
  latin_name?: string;
  animal_type?: string;
  active_time?: string;
  length_min?: number;
  length_max?: number;
  weight_min?: number;
  weight_max?: number;
  lifespan?: number;
  habitat?: string;
  diet?: string;
  geo_range?: string;
  image_link?: string;
  id?: number;

  constructor(object: Partial<Animal>){
    Object.assign(this, object);
  }
}
