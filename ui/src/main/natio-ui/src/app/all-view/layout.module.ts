import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {LayoutRoutingModule} from "./layout-routing.module";
import {LayoutComponent} from "./layout.component";
import {CustomMaterialModule} from "../core/module/CustomMaterialModule";
import {SessionStorageService} from "../core/lib/services/session-storage.service";

@NgModule({
  imports: [
    CommonModule,
    LayoutRoutingModule,
    CustomMaterialModule
  ],
  declarations: [LayoutComponent],
  providers: [SessionStorageService]
})
export class LayoutModule {
}
