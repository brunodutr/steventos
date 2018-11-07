import { Component, OnInit } from "@angular/core";
import { AuthService } from "src/app/services/auth.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"]
})
export class HeaderComponent implements OnInit {
  pages: Page[] = [
    {
      name: "Hospedagens",
      path: "/hospedagens"
    },
    {
      name: "Transportes",
      path: "/transportes"
    }
  ];

  constructor(private auth: AuthService) {}

  ngOnInit() {}
}

export interface Page {
  name: string;
  path: string;
}
