import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSnackBar, MatPaginator, MatSort } from '@angular/material';
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

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild('pagi2') paginator2: MatPaginator;
  @ViewChild('sort2') sort2: MatSort;

  constructor(private userService: UserService,private snackBar:MatSnackBar, private messageService: MessageService, private router: Router,private fb:FormBuilder) {
    this.adminform = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required],
      fullname: ['',Validators.required]
    });
   }

  ngOnInit() {
    this.userService.getAllWorkers().subscribe(data =>{
      this.workers = new MatTableDataSource(data);
      this.workers.paginator = this.paginator;
      this.workers.sort = this.sort;
    });
    this.userService.getUsers().subscribe(data =>{
      this.users = new MatTableDataSource(data);
      this.users.paginator = this.paginator2;
      this.users.sort = this.sort2;
    });
    this.messageService.getReports().subscribe(data =>{
      this.reports = new MatTableDataSource(data);
    });
  }
  ngAfterViewInit() {
  }
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.workers.filter = filterValue;
  }
  applyFilter2(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.users.filter = filterValue;
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
      this.snackbarMaintain();
      this.ngOnInit();
    });
  }
  snackbarMaintain() {
    this.snackBar.open('A karbantartás megtörtént!','Rendben' ,{
      duration: 3000,
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
      this.openSnackBarOk();
    },
  err=> console.log("err"));
  }
  openSnackBarOk() {
    this.snackBar.open('Az új adminisztrátort hozzáadta!','Rendben' ,{
      duration: 3000,
    });
    }

}
