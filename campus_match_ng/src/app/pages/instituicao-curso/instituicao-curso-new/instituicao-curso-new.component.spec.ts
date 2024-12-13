import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituicaoCursoNewComponent } from './instituicao-curso-new.component';

describe('InstituicaoCursoNewComponent', () => {
  let component: InstituicaoCursoNewComponent;
  let fixture: ComponentFixture<InstituicaoCursoNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InstituicaoCursoNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstituicaoCursoNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
