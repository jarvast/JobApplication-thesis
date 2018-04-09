import { Component, OnInit } from '@angular/core';
import { Server, Routes } from '../../utils/ServerRoutes';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserUser } from '../../model/UserUser';
import { AuthService } from '../../services/auth.service';
import { MatDialog } from '@angular/material';
import { WriteMessageDialogComponent } from '../messages/popups/write-message-dialog/write-message-dialog.component';
import { ReportDialogComponent } from '../messages/popups/report-dialog/report-dialog.component';

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
  cachebuster: number;

  constructor(public dialog : MatDialog,private route: ActivatedRoute, private userService: UserService,private authService: AuthService, private router: Router) {
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
  editProfile(){
      this.router.navigate(['/myuser', this.userId]);
    
  }
  writeMessage(){
    let dialogRefa = this.dialog.open(WriteMessageDialogComponent, {
      width: '30%',
      data :{receiver:this.user}
    });
    dialogRefa.afterClosed().subscribe(res =>{
    })
  }
  report(){
    let dialogRefa = this.dialog.open(ReportDialogComponent, {
      width: '30%',
      data :{receiver:this.user}
    });
    dialogRefa.afterClosed().subscribe(res =>{
    })
  }
  getTimeStamp(){
    return this.cachebuster;
  }

}
