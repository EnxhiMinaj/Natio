import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {LOCATION_POINT_DETAILS, NATIO} from "../../core/utility/navigation-url";
import {ExploreTrailsService} from "../../app-services/explore-trails.service";
import {ResponseModel} from "../../core/lib/model/response.model";
import {LocationPointsModel} from "../../models/location-points.model";




@Component({
  selector: 'app-explore-trails',
  templateUrl: './nature-location.component.html',
  styleUrls: ['./nature-location.component.scss']
})
export class NatureLocationComponent implements OnInit {

  locationPoints: LocationPointsModel[] = [];
  placeName:string;
  constructor(
              private _router: Router,
              private route: ActivatedRoute,
              private _exploreService: ExploreTrailsService

  ) {
    this.route.params.subscribe( params => {
      if(params){
        this.placeName = params.place;
        this.getLocationPoints(this.placeName);
      }
    });
  }

  ngOnInit() {

  }

  openLocationPointDetails(){
    let finalUrl = "/"+NATIO+  "/" + LOCATION_POINT_DETAILS;
    this._router.navigateByUrl(finalUrl);
  }

  getLocationPoints(placeName) {
    this._exploreService.getLocationPointsByZoneName(placeName).then((res:ResponseModel)=>{
        if(res.responseStatus){
          this.locationPoints = res.result;
        } else {
          this.locationPoints = [];
        }
    });
  }

  getLocationName(lat, lng, locationPoint) {
    this._exploreService.getLocationByLatAndLng(lat,lng).then(res=>{
      if(res['status']==200){
        let result = [];
        result = res['results'];
        let loc = result[0];
        let component = loc['components'];
        locationPoint['attraction'] = component['attraction'];

      }
    })
  }

}
