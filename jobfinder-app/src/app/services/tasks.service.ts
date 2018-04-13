import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Task } from '../model/Task';

@Injectable()
export class TasksService {

  constructor(private http: HttpClient) { }

  getTasks(id:number): Observable<Task[]>{
    return this.http.get<Task[]>(Server.routeTo(Routes.TASKSBYUSER) + '/' + id);
  }
  updateTask(task:Task){
    return this.http.post(Server.routeTo(Routes.UPDATETASK),task);
  }
  create(id:number, task:Task){
    return this.http.post(Server.routeTo(Routes.NEWTASK) + '/' + id, task);
  }
  deleteTask(id:number){
    return this.http.delete(Server.routeTo(Routes.TASKSBYUSER) + '/' + id);
  }

}
