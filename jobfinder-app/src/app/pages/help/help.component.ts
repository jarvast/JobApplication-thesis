import { Component, OnInit } from '@angular/core';
import { Server, Routes } from '../../utils/ServerRoutes';
import { AuthService } from '../../services/auth.service';
import { WorkerUser } from '../../model/WorkerUser';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit{
  title = 'JavaSampleApproach';
  fileUpload: String;// = Server.routeTo(Routes.PICTURE) + this.authService.user.username;// "http://localhost:4200/api/upload/files/user";
  description = 'Angular4-SpringBosot Demo';
  value = '';
  tiles = [
    {text: 'One', cols: 1, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 1, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
  ];
  workers : WorkerUser[];

  constructor(private authService: AuthService, private userService : UserService) {
    this.fileUpload = Server.routeTo(Routes.PICTURE); // + "user";
  }
  ngOnInit()
  {
    this.userService.getWorkers().subscribe(workers => {
      this.workers = workers;
    });
  }  
  //consturctorban a servicet meghívni
  submit(){
   /* this.searchservice.search(this.value)
      .subscribe(
        res => ...
      )*/
      console.log("ez a list" + this.workers.length);
      console.log("keresed ezt" + this.value);
  }

}
