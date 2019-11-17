import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CustomMaterialModule} from "../../core/module/CustomMaterialModule";
import {ChartsRoutingModule} from "./charts-routing.module";
import {ChartsComponent} from "./charts.component";
import {ChartModule} from "angular-highcharts";
import {HighchartsService} from "./charts.service";

@NgModule({
  imports: [
    CommonModule,
    CustomMaterialModule,
    ChartsRoutingModule,
    ChartModule
  ],
  declarations: [ChartsComponent],
  providers:    [HighchartsService],
  exports:[ChartsComponent]
})
export class ChartsGraphModule { }
