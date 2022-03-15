import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadFilmesComponent } from './cad-filmes.component';

describe('CadFilmesComponent', () => {
  let component: CadFilmesComponent;
  let fixture: ComponentFixture<CadFilmesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadFilmesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadFilmesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
