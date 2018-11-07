import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MatIconModule } from "@angular/material";
import { RouterModule } from "@angular/router";
import { LayoutComponent } from "../pages/impl/ui/layout/layout.component";
import { HeaderComponent } from "../pages/impl/ui/header/header.component";
import { FooterComponent } from "../pages/impl/ui/footer/footer.component";
import { LoginModule } from "./login.module";

@NgModule({
  imports: [MatIconModule, CommonModule, RouterModule, LoginModule],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent],
  exports: [LayoutComponent]
})
export class UiModule {}
