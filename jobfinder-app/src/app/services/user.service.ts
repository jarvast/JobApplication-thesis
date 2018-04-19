import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { WorkerUser } from '../model/WorkerUser';
import { UserUser } from '../model/UserUser';
import { AdminUser } from '../model/AdminUser';

@Injectable()
export class UserService {

  user : UserUser;
  worker: WorkerUser;

  constructor(private http: HttpClient) { }

  getWorkers(): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.ALLWORKERS));
  }
  getAllWorkers(): Observable<WorkerUser[]>{
    return this.http.get<WorkerUser[]>(Server.routeTo(Routes.ALLWORKERS) + '/all');
  }
  getUsers(): Observable<UserUser[]>{
    return this.http.get<UserUser[]>(Server.routeTo(Routes.ALLUSERS));
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
  maintain(){
    return this.http.get(Server.routeTo(Routes.ALLWORKERS) + '/maintain');
  }
  approve(id:number){
    return this.http.get(Server.routeTo(Routes.SINGLEWORKER) + '/approve/' + id);
  }
  deleteWorker(id:number){
    return this.http.delete(Server.routeTo(Routes.SINGLEWORKER) + '/delete/'+ id);
  }
  newAdmin(admin: AdminUser, pass:string){
    const httpOptions = {
    headers: new HttpHeaders({
      'pass': 'Basic ' + btoa(pass)
    })}
    return this.http.post(Server.routeTo(Routes.NEW) + '/admin',admin, httpOptions);
  }
  newUser(user: UserUser, pass:string){
    const httpOptions = {
    headers: new HttpHeaders({
      'pass': 'Basic ' + btoa(pass)
    })}
    return this.http.post(Server.routeTo(Routes.NEW) + '/user',user, httpOptions);
  }
  newWorker(worker: WorkerUser, pass:string):Observable<WorkerUser>{
    const httpOptions = {
    headers: new HttpHeaders({
      'pass': 'Basic ' + btoa(pass)
    })}
    return this.http.post<WorkerUser>(Server.routeTo(Routes.NEW) + '/worker',worker, httpOptions);
  }
}
