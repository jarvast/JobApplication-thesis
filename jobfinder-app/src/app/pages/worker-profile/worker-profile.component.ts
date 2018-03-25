import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { WorkerUser } from '../../model/WorkerUser';
import { Server, Routes } from '../../utils/ServerRoutes';
import { AuthService } from '../../services/auth.service';
import { LocationService } from '../../services/location.service';
import { Location } from '../../model/Location';

@Component({
  selector: 'app-worker-profile',
  templateUrl: './worker-profile.component.html',
  styleUrls: ['./worker-profile.component.css']
})
export class WorkerProfileComponent implements OnInit {
  workerId: number;
  worker : WorkerUser;
  imgRoute: String;
  locations : Location[];
  temp : String[];
  separatedLocations : String = "";
  ownprofile: boolean = false;
  cachebuster: number;

  constructor(private route: ActivatedRoute, private userService: UserService, private authService: AuthService, private locationService: LocationService, private router:Router) { 
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.workerId = param['id'];
      this.userService.getWorker(this.workerId).subscribe(data =>{
        this.worker=data;
        if (this.authService.user.id==this.workerId){
          this.ownprofile=true;
        }
      })
  });
  this.locationService.getLocations(this.workerId).subscribe(res => {
    this.locations = res;
  });
  this.cachebuster= Date.now();
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
  rut(){
    this.router.navigate(['/myworker', this.worker.id]);
  }
  getTimeStamp(){
    return this.cachebuster;
  }
}
