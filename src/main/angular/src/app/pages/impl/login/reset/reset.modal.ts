import { Component, OnInit } from "@angular/core";
import { AuthService } from "src/app/services/auth.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "reset-modal",
  templateUrl: "./reset.modal.html"
})
export class ResetPasswordModal implements OnInit {
  resetForm: FormGroup;
  constructor(private auth: AuthService, private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.resetForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]]
    });
  }

  onSubmit() {
    console.log(this.resetForm.value);
  }
}
