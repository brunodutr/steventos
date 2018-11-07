import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ModalComponent } from "../shared/modal/modal.component";
import { ModalBody } from "../shared/modal/modal.body";
import { ModalHeader } from "../shared/modal/modal.header";
import { ModalFooter } from "../shared/modal/modal.footer";

@NgModule({
  imports: [CommonModule],
  declarations: [ModalComponent, ModalHeader, ModalBody, ModalFooter],
  exports: [ModalComponent, ModalHeader, ModalBody, ModalFooter]
})
export class ModalModule {}
