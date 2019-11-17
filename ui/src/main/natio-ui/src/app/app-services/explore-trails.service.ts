import {Injectable} from "@angular/core";
import {UserProfileModel} from "../models/user-profile.model";
import {FTBaseService} from "../core/lib/services/ft-base.service";
import {HttpService} from "../core/lib/services/http.service";


@Injectable()
export class ExploreTrailsService extends FTBaseService {
  dataModel: {};

  serviceApi: string = '/natio/nature-locations';
  mapApi: string = "http://your-api-url";
  getAllMainZonesApi: string = this.serviceApi + '/get-all';
  getAllLocationPointApi: string = this.serviceApi + '/get-location-point/';


  constructor(httpService: HttpService) {
    super(httpService);
  }

  getAllNatureLocations(zone:string) {
    return this.httpService.getRequest(this.getAllMainZonesApi);
  }

  getLocationPointsByZoneName(zoneName:string) {
    return this.httpService.getRequest(this.getAllLocationPointApi + zoneName);
  }

  getLocationByLatAndLng(lat,lng) {
    return this.httpService.getLocation(lat,lng);
  }

}
