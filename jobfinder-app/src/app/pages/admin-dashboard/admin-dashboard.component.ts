import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { UserUser } from '../../model/UserUser';
import { WorkerUser } from '../../model/WorkerUser';
import { Message } from '../../model/Message';
import { UserService } from '../../services/user.service';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  users: MatTableDataSource<UserUser>;
  userColumns: String[] = ['name', 'email'];
  workers: MatTableDataSource<WorkerUser>;
  workerColumns: String[] = ['name', 'email'];
  reports: MatTableDataSource<Message>;
  reportColumns: String[] = ['sender','receiver'];

  constructor(private userService: UserService, private messageService: MessageService) {
    this.userService.getWorkers().subscribe(data =>{
      this.workers = new MatTableDataSource(data);
    });
    this.userService.getUsers().subscribe(data =>{
      this.users = new MatTableDataSource(data);
    });
    this.messageService.getReports().subscribe(data =>{
      this.reports = new MatTableDataSource(data);
    });
   }

  ngOnInit() {
  }

}
