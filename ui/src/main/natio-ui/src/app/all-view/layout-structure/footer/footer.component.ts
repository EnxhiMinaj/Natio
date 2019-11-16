import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {
  FIND_JOB_URL,
  ICREDIT_URL,
  MY_JOB_URL,
  PAY_URL,
  REDEEM_URL,
  WALLET_URL
} from "../../../core/utility/navigation-url";
import {EventService} from "../../../core/lib/services/event.service";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

    constructor(private _router: Router, private _eventService: EventService) {
    }

  ngOnInit() {
  }


}
