import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfraestruturaNewComponent } from './infraestrutura-new.component';

describe('InfraestruturaNewComponent', () => {
  let component: InfraestruturaNewComponent;
  let fixture: ComponentFixture<InfraestruturaNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfraestruturaNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfraestruturaNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
