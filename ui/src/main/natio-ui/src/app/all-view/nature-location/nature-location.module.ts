import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NatureLocationComponent} from './nature-location.component';
import {NatureLocationRoutingModule} from "./nature-location-routing.module";
import {CustomMaterialModule} from "../../core/module/CustomMaterialModule";

@NgModule({
  imports: [
    CommonModule,
    NatureLocationRoutingModule,
    CustomMaterialModule
  ],
  declarations: [NatureLocationComponent],
  providers: [

  ],
})
export class NatureLocationModule { }
