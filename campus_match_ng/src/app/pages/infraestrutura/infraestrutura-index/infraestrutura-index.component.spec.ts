import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfraestruturaIndexComponent } from './infraestrutura-index.component';

describe('InfraestruturaIndexComponent', () => {
  let component: InfraestruturaIndexComponent;
  let fixture: ComponentFixture<InfraestruturaIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfraestruturaIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfraestruturaIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
