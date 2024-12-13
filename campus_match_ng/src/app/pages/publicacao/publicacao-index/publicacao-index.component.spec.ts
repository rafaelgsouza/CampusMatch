import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicacaoIndexComponent } from './publicacao-index.component';

describe('PublicacaoIndexComponent', () => {
  let component: PublicacaoIndexComponent;
  let fixture: ComponentFixture<PublicacaoIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PublicacaoIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicacaoIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
