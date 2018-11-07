import { Component, Input } from "@angular/core";

@Component({
  selector: "modal-header",
  template: `
    <div class="modal-header" modal-header>
        <h5 class="modal-title">{{ title }}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    `
})
export class ModalHeader {
  @Input()
  title: string;
}
