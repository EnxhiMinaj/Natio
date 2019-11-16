import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {SessionStorageService} from "../core/lib/services/session-storage.service";

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {

  constructor(private _router: Router, private _sessionStorageService: SessionStorageService) {

  }

  ngOnInit() {

  }

}
