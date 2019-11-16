import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {EXPLORE_TRAILS, NATIO, NATURE_LOCATION} from "../../core/utility/navigation-url";




@Component({
  selector: 'app-explore-trails',
  templateUrl: './explore-trails.component.html',
  styleUrls: ['./explore-trails.component.scss']
})
export class ExploreTrailsComponent implements OnInit {


  constructor(
              private _router: Router,

  ) {

  }

  ngOnInit() {

  }

  openNatureLocation(){
    let finalUrl = "/"+NATIO+  "/" + NATURE_LOCATION;
    this._router.navigateByUrl(finalUrl);
  }


}
