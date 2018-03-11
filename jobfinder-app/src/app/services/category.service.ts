import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from '../model/Category';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) { }

  getCategories(): Observable<Category[]>{
    return this.http.get<Category[]>(Server.routeTo(Routes.CATEGORIES));
  }

}
