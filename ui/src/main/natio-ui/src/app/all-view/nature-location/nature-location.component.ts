import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {LOCATION_POINT_DETAILS, NATIO} from "../../core/utility/navigation-url";




@Component({
  selector: 'app-explore-trails',
  templateUrl: './nature-location.component.html',
  styleUrls: ['./nature-location.component.scss']
})
export class NatureLocationComponent implements OnInit {


  constructor(
              private _router: Router,

  ) {

  }

  ngOnInit() {

  }

  openLocationPointDetails(){
    let finalUrl = "/"+NATIO+  "/" + LOCATION_POINT_DETAILS;
    this._router.navigateByUrl(finalUrl);
  }


}
