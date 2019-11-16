import {AfterContentInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {HighchartsService} from "./charts.service";
import * as Highcharts from 'highcharts';


@Component({
  selector: 'app-output-graph',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.scss']
})
export class ChartsComponent implements OnInit, AfterContentInit {

  @ViewChild('charts') public chartEl: ElementRef;

  constructor(private highcharts: HighchartsService) { }
  ngOnInit(){

  }
  elevationData = [
    [ 0, 225],
    [ 1, 226],
    [ 2, 228],
    [ 3, 228],
    [ 4, 28],
    [ 5, 229],
    [ 6, 23],
    [ 7, 234],
    [ 8, 21],
    [ 9, 236],
    [ 10, 260],
    [ 11, 232],
    [ 12, 64],
    [ 13, 223],
    [ 14, 218],
    [ 15, 75],
    [ 16, 207],
    [ 17, 89],
    [ 18, 198],
    [ 19, 196],
    [ 20, 197],
    [ 21, 200],
    [ 22, 205],
    [ 23, 52],
  ];

  myOptions = {
    chart: {
      type: 'area',
      zoomType: 'x',
      panning: true,
      panKey: 'shift',
      scrollablePlotArea: {
        minWidth: 300
      }
    },

    caption: {
      text: 'This chart contains the hourly information about the number of people visiting the'
    },

    title: {
      text: 'Visit Finland'
    },

    credits: {
      enabled: false
    },
      xAxis: {
        labels: {
          format: '{value} hr'
        },
        minRange: 5,
        title: {
          text: 'Distance'
        },
        accessibility: {}
      },

      yAxis: {
        startOnTick: true,
        endOnTick: false,
        maxPadding: 0.35,
        title: {
          text: null
        },
        labels: {
          format: '{value}'
        }
      },

      tooltip: {
        headerFormat: 'Hours: {point.x:.1f} <br>',
        pointFormat: '{point.y}',
        shared: true
      },

      legend: {
        enabled: false
      },

      series: [{
        accessibility: {
          keyboardNavigation: {
            enabled: false
          }
        },
        data: this.elevationData,
        lineColor: Highcharts.getOptions().colors[1],
        color: Highcharts.getOptions().colors[2],
        fillOpacity: 0.5,
        name: 'Elevation',
        marker: {
          enabled: false
        },
        threshold: null

    }],
  };

  ngAfterContentInit(): void {
    this.highcharts.createChart(this.chartEl.nativeElement, this.myOptions);
  }
}
