import { Component, OnInit } from "@angular/core";
import { AuthService } from "src/app/services/auth.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "signin-modal",
  templateUrl: "./signin.modal.html"
})
export class SignInModal implements OnInit {
  loginForm: FormGroup;
  constructor(private auth: AuthService, private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      senha: ["", [Validators.required]]
    });
  }

  onSubmit() {
    this.auth.authenticate(
      this.getValue(this.loginForm, "email"),
      this.getValue(this.loginForm, "senha")
    );
  }

  getValue(form: FormGroup, control: string): string {
    return form.get(control).value;
  }
}
