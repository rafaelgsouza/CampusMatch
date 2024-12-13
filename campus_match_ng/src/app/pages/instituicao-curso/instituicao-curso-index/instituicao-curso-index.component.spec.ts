import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituicaoCursoIndexComponent } from './instituicao-curso-index.component';

describe('InstituicaoCursoIndexComponent', () => {
  let component: InstituicaoCursoIndexComponent;
  let fixture: ComponentFixture<InstituicaoCursoIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InstituicaoCursoIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstituicaoCursoIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
