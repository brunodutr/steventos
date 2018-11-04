import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map, mergeMap, flatMap } from "rxjs/operators";
import { Local } from "../model/local.model";

const URL_REST = "http://localhost:8080/rest/locais/autocomplete";

export const _filter = (opt: string[], value: string): string[] => {
  const filterValue = value.toLowerCase();

  return opt.filter(item => item.toLowerCase().indexOf(filterValue) === 0);
};

@Injectable({
  providedIn: "root"
})
export class CidadeService {
  cidadeJSON: Function;
  cidadeREST: Function;

  constructor(private http: HttpClient) {
    this.cidadeJSON = this.getCidades.bind(this);
    this.cidadeREST = this.getCidadesRest.bind(this);
  }

  private getCidades(texto: string): Observable<Local[]> {
    return this.http.get("/assets/estados-cidades.json").pipe(
      map((estados: Estado[]) =>
        estados.map(estado => {
          let cidadesFilter = _filter(estado.cidades, texto);
          if (cidadesFilter.length > 0) {
            estado.cidades = cidadesFilter;
            return estado;
          }
        })
      ),
      map((estados: Estado[]) =>
        estados
          .filter(estado => !!estado)
          .map((estado: Estado) =>
            estado.cidades.map(
              cidade =>
                new Local({ id: null, cidade: cidade, estado: estado.sigla })
            )
          )
          .reduce((estados, val) => estados.concat(val), [])
      )
    );
  }

  private getCidadesRest(texto: string): Observable<Local[]> {
    return this.http.post<Local[]>(
      URL_REST,
      new AutocompleteFilter(texto, "cidade"),
      {
        headers: new HttpHeaders({
          "Content-Type": "application/json"
        })
      }
    );
  }
}

export interface Estado {
  sigla: string;
  nome: string;
  cidades: string[];
}

export class AutocompleteFilter {
  private texto: string;
  private campo: string;

  constructor(texto, campo) {
    this.texto = texto;
    this.campo = campo;
  }
}
