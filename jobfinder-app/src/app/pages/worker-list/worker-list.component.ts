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
  selectedOption ="";
  categoryName : String;
  selectedWorkers: WorkerUser[];
  imgRoute: String;
  foundArrayLength : number;

  constructor(private route: ActivatedRoute, private userService: UserService) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
   }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.categoryName = param['id'];
      if (this.categoryName.startsWith("searchFor")){
        this.userService.searchForWorkers(this.categoryName).subscribe(data =>{
          this.selectedWorkers = data;
          this.foundArrayLength = this.selectedWorkers.length;
        });
      }else{
        this.userService.getWorkersByCategory(this.categoryName).subscribe(data => {
          this.selectedWorkers = data;
          this.foundArrayLength = this.selectedWorkers.length;
        });
      }
    });
    //console.log("ez a tab" + this.categoryName);
  }
  sortbyBestRating(){
    this.selectedWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.rating > rightSide.rating) return -1;
      if (leftSide.rating < rightSide.rating) return 1;
      return 0;
    });
  }
  sortbyWorstRating(){
    this.selectedWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.rating < rightSide.rating) return -1;
      if (leftSide.rating > rightSide.rating) return 1;
      return 0;
    });
  }
  sortbyNameZA(){
    this.selectedWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.name > rightSide.name) return -1;
      if (leftSide.name < rightSide.name) return 1;
      return 0;
    });
  }
  sortbyNameAZ(){
    this.selectedWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.name < rightSide.name) return -1;
      if (leftSide.name > rightSide.name) return 1;
      return 0;
    });
  }

}
