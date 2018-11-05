import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HospedagensListComponent } from './hospedagens-list.component';

describe('HospedagensListComponent', () => {
  let component: HospedagensListComponent;
  let fixture: ComponentFixture<HospedagensListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HospedagensListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HospedagensListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
