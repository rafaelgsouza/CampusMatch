import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituicaoIndexComponent } from './instituicao-index.component';

describe('InstituicaoIndexComponent', () => {
  let component: InstituicaoIndexComponent;
  let fixture: ComponentFixture<InstituicaoIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InstituicaoIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstituicaoIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
