import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { WorkerUser } from '../model/WorkerUser';
import { UserUser } from '../model/UserUser';

@Injectable()
export class UserService {

  user : UserUser;
  worker: WorkerUser;

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
  getTop5(): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.ALLWORKERS) + '/top');
  }
  getUser(id: number) : Observable<UserUser>{
    return this.http.get<UserUser>(Server.routeTo(Routes.SINGLEUSER) + '/' + id);
  }
  updateUser(user: UserUser){
    return this.http.post(Server.routeTo(Routes.SINGLEUSER), user);
  }
  updateWorker(worker: WorkerUser){
    return this.http.post(Server.routeTo(Routes.SINGLEWORKER), worker);
  }
  putFavorite(id:number){
    return this.http.get(Server.routeTo(Routes.FAVORITE)+ '/' + id);
  }
  listFavorites(): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.FAVORITE));
  }
  notFavorite(id:number){
    return this.http.get(Server.routeTo(Routes.FAVORITE) + '/remove/' + id);
  }
}
