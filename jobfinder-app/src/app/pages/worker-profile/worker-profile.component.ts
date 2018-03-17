import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../services/user.service';
import { WorkerUser } from '../../model/WorkerUser';
import { Server, Routes } from '../../utils/ServerRoutes';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-worker-profile',
  templateUrl: './worker-profile.component.html',
  styleUrls: ['./worker-profile.component.css']
})
export class WorkerProfileComponent implements OnInit {
  workerId: number;
  worker : WorkerUser;
  imgRoute: String;

  constructor(private route: ActivatedRoute, private userService: UserService, private authService: AuthService) { 
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.workerId = param['id'];
      this.userService.getWorker(this.workerId).subscribe(data =>{
        this.worker=data;
      })
  });
  }
  //lehet az egész gombokat ki lehetne szervezni
  sendMessage(){
    if (this.authService.isLoggedIn){
      console.log("send");
    }else{
      console.log("empty");
    }
  }
  favorite(){
    console.log("fam");
  }
  report(){
    console.log("report")
  }
  reservation(){
    console.log("reserve")
  }
}
