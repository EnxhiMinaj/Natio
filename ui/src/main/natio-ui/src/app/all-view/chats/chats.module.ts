import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChatsComponent} from './chats.component';
import {CustomMaterialModule} from "../../core/module/CustomMaterialModule";
import {ChatsRoutingModule} from "./chats-routing.module";

@NgModule({
  imports: [
    CommonModule,
    CustomMaterialModule,
    ChatsRoutingModule,
  ],
  declarations: [ChatsComponent],
  providers: [

  ],
})
export class ChatsModule { }
