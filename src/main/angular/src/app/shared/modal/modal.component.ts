import { Component, Input } from "@angular/core";

@Component({
  selector: "steventos-modal",
  templateUrl: "./modal.component.html"
})
export class ModalComponent {
  @Input()
  target: string;
}
