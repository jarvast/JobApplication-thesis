import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Location } from '../model/Location';
import { Server, Routes } from '../utils/ServerRoutes';

@Injectable()
export class LocationService {

  constructor(private http: HttpClient) { }

  getLocations(id:number): Observable<Location[]>{
    return this.http.get<Location[]>(Server.routeTo(Routes.LOCATION) + '/' + id);
  }
  getAllLocations(): Observable<Location[]>{
    return this.http.get<Location[]>(Server.routeTo(Routes.LOCATION));
  }
  updateLocations(locations: Location[], id: number){
    return this.http.post(Server.routeTo(Routes.LOCATION) + '/update/' + id,locations);
  }

}
