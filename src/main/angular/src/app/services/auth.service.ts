import { Injectable } from "@angular/core";
import { AngularFireAuth } from "@angular/fire/auth";
import { LocalStorage } from "@ngx-pwa/local-storage";
import { Pessoa } from "../models/pessoa.model";
import { PessoaService } from "./impl/pessoa.service";

@Injectable({
  providedIn: "root"
})
export class AuthService {
  usuarioLogado: Pessoa;

  constructor(
    private localStorage: LocalStorage,
    private auth: AngularFireAuth,
    private pessoaService: PessoaService
  ) {}

  createUser(email: string, senha: string): Promise<any> {
    return this.auth.auth.createUserWithEmailAndPassword(email, senha);
  }

  async authenticate(email: string, senha: string) {
    await this.auth.auth.signInWithEmailAndPassword(email, senha);

    let token = await this.auth.idToken;

    this.localStorage.setItem("token", token);

    this.usuarioLogado = await this.pessoaService
      .findByEmail(email)
      .toPromise();

    console.log(this.usuarioLogado);
  }
}
