import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpHeaders
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LocalStorage } from "@ngx-pwa/local-storage";
import { Observable } from "rxjs";

@Injectable()
export class HttpsRequestInterceptor implements HttpInterceptor {
  token: string = "DEFAULT";
  constructor(private localStorage: LocalStorage) {}

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json",
      Authorization: this.token
    })
  };

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    this.token = localStorage.getItem("token");
    const dupReq = req.clone(this.httpOptions);
    return next.handle(dupReq);
  }
}
