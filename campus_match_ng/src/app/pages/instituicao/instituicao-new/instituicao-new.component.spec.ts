import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituicaoNewComponent } from './instituicao-new.component';

describe('InstituicaoNewComponent', () => {
  let component: InstituicaoNewComponent;
  let fixture: ComponentFixture<InstituicaoNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InstituicaoNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstituicaoNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
