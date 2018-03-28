import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../services/user.service';
import { WorkerUser } from '../../model/WorkerUser';
import { Server, Routes } from '../../utils/ServerRoutes';

@Component({
  selector: 'app-favorite-list',
  templateUrl: './favorite-list.component.html',
  styleUrls: ['./favorite-list.component.css']
})
export class FavoriteListComponent implements OnInit {

  favoriteWorkers: WorkerUser[];
  imgRoute: String;

  constructor(private route: ActivatedRoute, private userService: UserService) { 
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }

  ngOnInit() {
    this.userService.listFavorites().subscribe(data =>{
      this.favoriteWorkers=data;
    });
  }

  sortbyBestRating(){
    this.favoriteWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.rating > rightSide.rating) return -1;
      if (leftSide.rating < rightSide.rating) return 1;
      return 0;
    });
  }
  sortbyWorstRating(){
    this.favoriteWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.rating < rightSide.rating) return -1;
      if (leftSide.rating > rightSide.rating) return 1;
      return 0;
    });
  }
  sortbyNameZA(){
    this.favoriteWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.name > rightSide.name) return -1;
      if (leftSide.name < rightSide.name) return 1;
      return 0;
    });
  }
  sortbyNameAZ(){
    this.favoriteWorkers.sort((leftSide,rightSide): number =>{
      if (leftSide.name < rightSide.name) return -1;
      if (leftSide.name > rightSide.name) return 1;
      return 0;
    });
  }

}
