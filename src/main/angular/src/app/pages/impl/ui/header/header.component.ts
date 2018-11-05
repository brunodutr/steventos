import { Component, OnInit } from "@angular/core";

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

  constructor() {}

  ngOnInit() {}
}

export interface Page {
  name: string;
  path: string;
}
