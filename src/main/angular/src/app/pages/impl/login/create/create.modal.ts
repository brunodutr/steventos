import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Roles } from "src/app/constants/role.constant";
import { AuthService } from "src/app/services/auth.service";
import { PessoaService } from "src/app/services/impl/pessoa.service";
import { Pessoa } from "src/app/models/pessoa.model";

@Component({
  selector: "create-modal",
  templateUrl: "./create.modal.html"
})
export class CreateUserModal implements OnInit {
  pessoaForm: FormGroup;
  roles: any;

  constructor(
    private auth: AuthService,
    private formBuilder: FormBuilder,
    private pessoaService: PessoaService
  ) {}

  ngOnInit(): void {
    this.pessoaForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      senha: ["", [Validators.required]],
      nome: ["", [Validators.required, Validators.minLength(5)]],
      dataNascimento: [new Date(), [Validators.required]],
      perfil: ["", [Validators.required]]
    });

    this.roles = Roles;
  }

  onSubmit() {
    let pessoa = new Pessoa(this.pessoaForm.value);

    let email: string = this.pessoaForm.get("email").value;
    let senha: string = this.pessoaForm.get("senha").value;
    
    this.auth.createUser(email, senha).then(() => {
      this.pessoaService.create(pessoa);
    });
    
    console.log(pessoa);
  }
}
