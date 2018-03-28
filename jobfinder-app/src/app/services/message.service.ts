import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Message } from '../model/Message';

@Injectable()
export class MessageService {

  constructor(private http: HttpClient) { }

  getMessages(myId:number): Observable<Message[]>{
    return this.http.get<Message[]>(Server.routeTo(Routes.MESSAGES) + '/' + myId);
  }

}
