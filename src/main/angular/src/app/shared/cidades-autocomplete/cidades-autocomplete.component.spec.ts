import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CidadesAutocompleteComponent } from './cidades-autocomplete.component';

describe('CidadesAutocompleteComponent', () => {
  let component: CidadesAutocompleteComponent;
  let fixture: ComponentFixture<CidadesAutocompleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CidadesAutocompleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CidadesAutocompleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
