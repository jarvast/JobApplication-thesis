import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Task } from '../model/Task';

@Injectable()
export class TasksService {

  constructor(private http: HttpClient) { }

  getTasks(id:number): Observable<Task[]>{
    return this.http.get<Task[]>(Server.routeTo(Routes.TASKS) + '/' + id);
  }

}
