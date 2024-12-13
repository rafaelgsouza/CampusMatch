import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudanteIndexComponent } from './estudante-index.component';

describe('EstudanteIndexComponent', () => {
  let component: EstudanteIndexComponent;
  let fixture: ComponentFixture<EstudanteIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EstudanteIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudanteIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
