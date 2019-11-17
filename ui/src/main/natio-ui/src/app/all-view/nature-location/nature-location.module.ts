import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NatureLocationComponent} from './nature-location.component';
import {NatureLocationRoutingModule} from "./nature-location-routing.module";
import {CustomMaterialModule} from "../../core/module/CustomMaterialModule";
import {ExploreTrailsService} from "../../app-services/explore-trails.service";

@NgModule({
  imports: [
    CommonModule,
    NatureLocationRoutingModule,
    CustomMaterialModule
  ],
  declarations: [NatureLocationComponent],
  providers: [
    ExploreTrailsService
  ],
})
export class NatureLocationModule { }
