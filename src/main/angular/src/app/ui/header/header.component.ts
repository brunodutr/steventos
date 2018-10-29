import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"]
})
export class HeaderComponent implements OnInit {
  pages: Page[] = [
    {
      name: "Restaurantes",
      path: "/restaurantes"
    },
    {
      name: "Hospedagens",
      path: "/hospedagens"
    }
  ];

  constructor() {}

  ngOnInit() {}
}

export interface Page {
  name: string;
  path: string;
}
