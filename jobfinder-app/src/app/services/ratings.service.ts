import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Rating } from '../model/Rating';

@Injectable()
export class RatingsService {

  constructor(private http: HttpClient) { }

  getAllRatingsByWorker(id:number): Observable<Rating[]>{
    return this.http.get<Rating[]>(Server.routeTo(Routes.RATING) + '/worker/' + id);
  }
  newRating(rating: Rating){
    return this.http.post(Server.routeTo(Routes.RATING),rating);
  }

}
