import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicacaoNewComponent } from './publicacao-new.component';

describe('PublicacaoNewComponent', () => {
  let component: PublicacaoNewComponent;
  let fixture: ComponentFixture<PublicacaoNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PublicacaoNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicacaoNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
