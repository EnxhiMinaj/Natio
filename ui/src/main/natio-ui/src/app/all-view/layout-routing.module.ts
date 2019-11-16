import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LayoutComponent} from "./layout.component";
import {CHATS, MAIN_URL, MY_TRIPS, SUGGESTIONS} from "../core/utility/navigation-url";

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {path: '', redirectTo: 'home'},
      {path: MAIN_URL, loadChildren: './explore-trails/explore-trails.module#ExploreTrailsModule'},
      {path: MY_TRIPS, loadChildren: './my-trips/my-trips.module#MyTripsModule'},
      {path: SUGGESTIONS, loadChildren: './suggestions/suggestions.module#SuggestionsModule'},
      {path: CHATS, loadChildren: './chats/chats.module#ChatsModule'},

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule {
}
