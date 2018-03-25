import { Component, OnInit } from '@angular/core';
import { Server, Routes } from '../../utils/ServerRoutes';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserUser } from '../../model/UserUser';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userId: number;
  imgRoute: String;
  user: UserUser;
  ownprofile: boolean = false;
  asdo :boolean;
  cachebuster: number;

  constructor(private route: ActivatedRoute, private userService: UserService,private authService: AuthService, private router: Router) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
   }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.userId = param['id'];
      this.userService.getUser(this.userId).subscribe(data =>{
        this.user=data;
        if (this.authService.user.id==this.userId){
          this.ownprofile=true;
        }
      })
  });
    this.cachebuster= Date.now();
  }
  rut(){
      this.router.navigate(['/myuser', this.userId]);
    
  }
  getTimeStamp(){
    return this.cachebuster;
  }

}
