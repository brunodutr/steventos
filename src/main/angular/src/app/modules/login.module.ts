import { NgModule } from "@angular/core";
import { SignInModal } from "../pages/impl/login/signin/signin.modal";
import { CommonModule } from "@angular/common";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { ModalModule } from "./modal.module";
import { CreateUserModal } from "../pages/impl/login/create/create.modal";
import { ResetPasswordModal } from "../pages/impl/login/reset/reset.modal";

@NgModule({
  imports: [CommonModule, ModalModule, FormsModule, ReactiveFormsModule],
  declarations: [SignInModal, CreateUserModal, ResetPasswordModal],
  exports: [SignInModal, CreateUserModal, ResetPasswordModal]
})
export class LoginModule {}
