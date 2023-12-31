import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './components/app/app.component';
import { CarsComponent } from './components/cars/cars.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { ClientsComponent } from './components/clients/clients.component';
import { AboutComponent } from './components/about/about.component';
import { RentsHistoryComponent } from './components/rents-history/rents-history.component';
import {RouterModule} from "@angular/router";
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, notFoundPageUrl, rentsHistoryUrl} from "./models/urls";
import { HomeComponent } from './components/home/home.component';
import {A} from "@angular/cdk/keycodes";
import { NotFoundComponent } from './components/not-found/not-found.component';
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    TopBarComponent,
    NavigationBarComponent,
    ClientsComponent,
    AboutComponent,
    RentsHistoryComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatButtonToggleModule,
    RouterModule.forRoot([
      {path: homePageUrl, component: HomeComponent},
      {path: rentsHistoryUrl, component: RentsHistoryComponent},
      {path: carsUrl, component: CarsComponent},
      {path: clientsUrl, component: ClientsComponent},
      {path: aboutUrl, component: AboutComponent},
      {path: notFoundPageUrl, component: NotFoundComponent}

    ]),
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
