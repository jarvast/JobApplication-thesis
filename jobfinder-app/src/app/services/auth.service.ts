import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Routes, Server } from "../utils/ServerRoutes";
import { User } from "../model/User";
import { Observable } from 'rxjs/Observable';
import { Role } from '../model/Role';

@Injectable()
export class AuthService {
  user: User;// = new User();
  isLoggedIn: boolean = false;

  constructor(private http: HttpClient) {
    this.user = new User(new Role());
  }

  login(user: User) {
    const httpOptions = {
    headers: new HttpHeaders({
      'Authorization': 'Basic ' + btoa(user.username + ':' + user.password)
    })
    };
    return this.http.post<User>(Server.routeTo(Routes.LOGIN), {}, httpOptions);
  }

  logout() {
    return this.http.post(Server.routeTo(Routes.LOGOUT), {});
  }

}
