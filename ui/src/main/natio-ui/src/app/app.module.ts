import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AdminAuthGuardService} from "./core/lib/services/admin-auth-guard.service";
import {AuthGuard} from "./core/lib/services/auth-guard.service";
import {CustomValidator} from "./core/lib/services/custom-validator.service";
import {SessionStorageService} from "./core/lib/services/session-storage.service";
import {HttpService} from "./core/lib/services/http.service";
import {RequestInterceptor} from "./core/lib/interceptor/request.interceptor";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {EventService} from "./core/lib/services/event.service";
import {ErrorStateMatcher, ShowOnDirtyErrorStateMatcher} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: RequestInterceptor,
    multi: true
  },
    {provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher},
    HttpService,
    SessionStorageService,
    CustomValidator,
    AuthGuard,
    EventService,
    AdminAuthGuardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
