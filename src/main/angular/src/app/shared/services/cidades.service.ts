import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map, filter } from "rxjs/operators";

export const _filter = (opt: string[], value: string): string[] => {
  const filterValue = value.toLowerCase();

  return opt.filter(item => item.toLowerCase().indexOf(filterValue) === 0);
};

@Injectable({
  providedIn: "root"
})
export class CidadeService {
  constructor(private http: HttpClient) {
    this.getCidades("Rio de").subscribe(res => {
      console.log(res);
    });
  }

  public getCidades(texto: string): Observable<any> {
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
      map((estados: Estado[]) => estados.filter(estado => !!estado))
    );
  }
}

export interface Estado {
  sigla: string;
  nome: string;
  cidades: string[];
}
