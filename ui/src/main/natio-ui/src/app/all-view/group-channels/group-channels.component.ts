import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {NATIO, CHAT_CHANNEL, CHANNEL} from "../../core/utility/navigation-url";


@Component({
  selector: 'app-explore-trails',
  templateUrl: './group-channels.component.html',
  styleUrls: ['./group-channels.component.scss']
})
export class GroupChannelsComponent implements OnInit {


  constructor(
              private _router: Router,

  ) {

  }

  ngOnInit() {

  }
  openChannel(channelName){
    let finalUrl = "/"+NATIO+  "/" + CHANNEL +"/"+channelName;
    this._router.navigateByUrl(finalUrl);
  }

}
