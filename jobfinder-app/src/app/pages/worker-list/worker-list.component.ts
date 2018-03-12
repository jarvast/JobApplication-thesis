import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../services/user.service';
import { WorkerUser } from '../../model/WorkerUser';
import { Server, Routes } from '../../utils/ServerRoutes';

@Component({
  selector: 'app-worker-list',
  templateUrl: './worker-list.component.html',
  styleUrls: ['./worker-list.component.css']
})
export class WorkerListComponent implements OnInit {

  categoryName : String;
  private sub: any;
  selectedWorkers: WorkerUser[];
  fileUpload: String;

  constructor(private route: ActivatedRoute, private userService: UserService) {
    this.fileUpload = Server.routeTo(Routes.PICTURE);
   }

  ngOnInit() {
    this.sub = this.route.params.subscribe(param => {
      this.categoryName = param['id'];
    });
    console.log("ez a tab" + this.categoryName);
    this.userService.getWorkersByCategory(this.categoryName).subscribe(data => {
      this.selectedWorkers = data;
    })
  }

}
