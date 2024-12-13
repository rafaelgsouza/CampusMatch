import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstudanteNewComponent } from './estudante-new.component';

describe('EstudanteNewComponent', () => {
  let component: EstudanteNewComponent;
  let fixture: ComponentFixture<EstudanteNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EstudanteNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstudanteNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
