import { Injectable } from '@angular/core';
import { HttpClient,HttpRequest,HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Routes, Server } from "../utils/ServerRoutes";
import { Image } from '../model/Image';

@Injectable()
export class UploadFileService {
 
  constructor(private http: HttpClient) {}
 
  pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
 
    //file.
    formdata.append('file', file);
 
    const req = new HttpRequest('POST', Server.routeTo(Routes.UPLOADASD), formdata, {
      reportProgress: true,
      responseType: 'text'
    });
 
    return this.http.request(req);
  }
 
  /*getFiles(): Observable<String[]> {
    return this.http.get<String[]>(Server.routeTo(Routes.UPLOAD));
  }*/
  getFiles() :Observable<Image>{
    return this.http.get<Image>(Server.routeTo(Routes.UPLOAD));
  }
}