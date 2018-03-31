import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';
import { Message } from '../model/Message';

@Injectable()
export class MessageService {

  constructor(private http: HttpClient) { }

  getSentMessages(myId:number): Observable<Message[]>{
    return this.http.get<Message[]>(Server.routeTo(Routes.MESSAGES) + '/' + myId);
  }
  getReceivedMessages(myId:number): Observable<Message[]>{
    return this.http.get<Message[]>(Server.routeTo(Routes.MESSAGES) + '/received/' + myId);
  }
  seeMessage(messageId:number): Observable<Message>{
    return this.http.get<Message>(Server.routeTo(Routes.MESSAGES) + '/see/' + messageId);
  }
  newMessages(myId:number): Observable<Message[]>{
    return this.http.get<Message[]>(Server.routeTo(Routes.MESSAGES) + '/new/' + myId);
  }
  send(message:Message){
    return this.http.post(Server.routeTo(Routes.MESSAGES) + '/send',message);
  }
  requestRating(myId: number){
    return this.http.get(Server.routeTo(Routes.MESSAGES) + '/rating/' + myId);
  }

}
