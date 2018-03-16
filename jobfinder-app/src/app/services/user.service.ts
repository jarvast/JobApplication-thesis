import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { WorkerUser } from '../model/WorkerUser';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  getWorkers(): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.ALLWORKERS));
  }

  getWorkersByCategory(categoryName : String): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.ALLWORKERS) + '/' + categoryName);
  }
  searchForWorkers(searchword: String): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.SEARCHWORKERS) + '/' + searchword);
  }
  getWorker(id: number) : Observable<WorkerUser>{
    return this.http.get<WorkerUser>(Server.routeTo(Routes.SINGLEWORKER) + '/' + id);
  }
}
