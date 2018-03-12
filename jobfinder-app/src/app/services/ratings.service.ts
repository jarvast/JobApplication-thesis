import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Rate } from '../model/Rate';

@Injectable()
export class RatingsService {

  constructor(private http: HttpClient) { }

  getRating(id:number): Observable<Rate>{
    return this.http.get<Rate>(Server.routeTo(Routes.RATING) + '/' + id);
  }

}
