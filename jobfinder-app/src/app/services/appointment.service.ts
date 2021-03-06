import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Appointment } from '../model/Appointment';
import { Observable } from 'rxjs/Observable';
import { Server, Routes } from '../utils/ServerRoutes';

@Injectable()
export class AppointmentService {

  constructor(private http: HttpClient) {}

  getAppointments(id:number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(Server.routeTo(Routes.APPOINTMENTS) + '/' + id);
  }
  getOccupiedAppointments(id:number): Observable<Appointment[]>{
    return this.http.get<Appointment[]>(Server.routeTo(Routes.APPOINTMENTS) + '/occupied/' + id);
  }
  reserve(id: number){
    return this.http.delete<Appointment>(Server.routeTo(Routes.APPOINTMENTS) + '/' + id);
  }
  create(appointment: Appointment, id: number){
    return this.http.post(Server.routeTo(Routes.APPOINTMENTS) + '/create/' + id,appointment);
  }
  deleteApp(id:number){
    return this.http.delete(Server.routeTo(Routes.APPOINTMENTS) + '/delete/' + id);
  }

}
