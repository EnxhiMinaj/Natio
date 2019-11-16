import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ExploreTrailsComponent} from './explore-trails.component';
import {ExploreTrailsRoutingModule} from "./explore-trails-routing.module";
import {CustomMaterialModule} from "../../core/module/CustomMaterialModule";

@NgModule({
  imports: [
    CommonModule,
    ExploreTrailsRoutingModule,
    CustomMaterialModule
  ],
  declarations: [ExploreTrailsComponent],
  providers: [

  ],
})
export class ExploreTrailsModule { }
