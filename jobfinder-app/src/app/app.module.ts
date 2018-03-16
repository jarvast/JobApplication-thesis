import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { MenuComponent } from './pages/menu/menu.component';
import { MaterialItemsModule } from './MaterialItemsModule';
import { RouterModule } from '@angular/router';
import { appRoutes } from './routes';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { RouteGuard } from './route.guard';
import { MainComponent } from './pages/help/help.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { UploadFileService } from './upload/upload-file.service';
import { UserService } from './services/user.service';
import { CategoryService } from './services/category.service';
import { WorkerListComponent } from './pages/worker-list/worker-list.component';
import { RatingComponent } from './pages/rating/rating.component';
import { RatingsService } from './services/ratings.service';
import { CommonModule } from '@angular/common';
import { LocationsComponent } from './pages/locations/locations.component';
import { LocationService } from './services/location.service';
import { TruncatePipe } from './utils/TruncatePipe';
import { WorkerProfileComponent } from './pages/worker-profile/worker-profile.component';
import { TaskTableComponent } from './pages/task-table/task-table.component';
import { TasksService } from './services/tasks.service';
import { RatingDetailedComponent } from './pages/rating-detailed/rating-detailed.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    MainComponent,
    FormUploadComponent,
    WorkerListComponent,
    RatingComponent,
    LocationsComponent,
    TruncatePipe,
    WorkerProfileComponent,
    TaskTableComponent,
    RatingDetailedComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MaterialItemsModule
  ],
  providers: [AuthService, RouteGuard, UploadFileService, UserService, CategoryService, RatingsService, LocationService, TasksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
