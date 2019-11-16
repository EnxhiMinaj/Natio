import {Component, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";
import {SessionStorageService} from "../core/lib/services/session-storage.service";
import {CHANGE_PASS, NATIO, PROFILE_URL} from "../core/utility/navigation-url";

import {MatSidenav} from "@angular/material";

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
  @ViewChild("sidenav")
  sideNav: MatSidenav;
  //userProfileModel: UserProfileModel;
  showLoggedInMenus: boolean  = false;

  constructor(private _router: Router, private _sessionStorageService: SessionStorageService) {

  }

  ngOnInit() {
    this.initForm();
    this.showLoggedInMenus = !!this._sessionStorageService.getToken();
  }
  initForm() {

  }
  openUserProfile() {
    let finalUrl = "/" + NATIO + "/" + PROFILE_URL;
    this.sideNav.toggle();
    this.sideNav.autoFocus = false;
    this._router.navigateByUrl(finalUrl);

  }
  changePwd(){
    let finalUrl = "/" + NATIO + "/" + CHANGE_PASS;
    this.sideNav.toggle();
    this.sideNav.autoFocus = false;
    this._router.navigateByUrl(finalUrl);
  }
  logout() {

  }
  login() {

  }
}
