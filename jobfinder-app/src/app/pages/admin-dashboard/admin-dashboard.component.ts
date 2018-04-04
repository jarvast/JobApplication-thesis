import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { UserUser } from '../../model/UserUser';
import { WorkerUser } from '../../model/WorkerUser';
import { Message } from '../../model/Message';
import { UserService } from '../../services/user.service';
import { MessageService } from '../../services/message.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminUser } from '../../model/AdminUser';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  users: MatTableDataSource<UserUser>;
  userColumns: String[] = ['name', 'username','date','edit'];
  workers: MatTableDataSource<WorkerUser>;
  workerColumns: String[] = ['name', 'username', 'date','approved','edit'];
  reports: MatTableDataSource<Message>;
  reportColumns: String[] = ['sender','receiver','content'];
  adminform: FormGroup;

  constructor(private userService: UserService, private messageService: MessageService, private router: Router,private fb:FormBuilder) {
    this.adminform = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required],
      fullname: ['',Validators.required]
    });
   }

  ngOnInit() {
    this.userService.getAllWorkers().subscribe(data =>{
      this.workers = new MatTableDataSource(data);
    });
    this.userService.getUsers().subscribe(data =>{
      this.users = new MatTableDataSource(data);
    });
    this.messageService.getReports().subscribe(data =>{
      this.reports = new MatTableDataSource(data);
    });
  }
  route(user: UserUser | WorkerUser){
    if (user.role.role == "WORKER"){
      this.router.navigate(['/worker', user.id ]);
    }else if (user.role.role =="USER"){
      this.router.navigate(['/user', user.id ]);
    }
  }
  maintain(){
    this.userService.maintain().subscribe(res =>{
      //opensnack
    });
  }
  approveWorker(id:number){
    this.userService.approve(id).subscribe(res =>{
      this.ngOnInit();      
    });
    
  }
  deleteWorker(id:number){
    this.userService.deleteWorker(id).subscribe(res =>{
      this.ngOnInit();
    });
  }
  get username() {
    return this.adminform.get('username')
  }
  get password() {
    return this.adminform.get('password')
  }
  get fullname() {
    return this.adminform.get('fullname')
  }
  submit(){
    this.userService.newAdmin(new AdminUser(this.username.value,'',this.fullname.value,"Admin"),this.password.value).subscribe(data=>{

    },
  err=> console.log("bar"));
  }

}
