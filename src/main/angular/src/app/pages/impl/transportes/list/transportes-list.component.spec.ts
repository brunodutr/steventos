import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { TransportesListComponent } from "./transportes-list.component";

describe("TransportesListComponent", () => {
  let component: TransportesListComponent;
  let fixture: ComponentFixture<TransportesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TransportesListComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransportesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
