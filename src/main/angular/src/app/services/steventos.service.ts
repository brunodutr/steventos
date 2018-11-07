import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

const REST_URL = "http://localhost:8080/rest";

export class SteventosService<T> {
  URL_REST: string;

  constructor(private http: HttpClient, private path: string) {
    this.URL_REST = `${REST_URL}/${this.path}`;
  }

  getAll(): Observable<T[]> {
    return this.http.get<T[]>(this.URL_REST);
  }

  getId(id: number): Observable<T> {
    return this.http.get<T>(`${this.URL_REST}/${id}`);
  }

  create(entity: T): Promise<T> {
    return this.http.post<T>(this.URL_REST, entity).toPromise();
  }

  update(id: number, entity: T) {
    return this.http.put<T>(`${this.URL_REST}/${id}`, entity);
  }

  delete(id: number) {
    return this.http.delete(`${this.URL_REST}/${id}`);
  }

  protected getField(id: number, campo: string): Observable<[]> {
    return this.http.get<[]>(`${this.URL_REST}/${id}/${campo}`);
  }

  protected setField(id: number, campo: string, entity: AddField<T>) {
    return this.http.post<T[]>(`${this.URL_REST}/${id}/${campo}`, entity);
  }

  getAutocomplete(filter: AutocompleteFilter) {
    return this.http.post<T[]>(`${this.URL_REST}/autocomplete`, filter);
  }
}

export interface AddField<T> {
  className: string;
  object: T;
}

export class AutocompleteFilter {
  private texto: string;
  private campo: string;

  constructor(texto, campo) {
    this.texto = texto;
    this.campo = campo;
  }
}
