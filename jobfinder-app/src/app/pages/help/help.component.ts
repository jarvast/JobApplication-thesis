import { Component, OnInit } from '@angular/core';
import { Server, Routes } from '../../utils/ServerRoutes';
import { AuthService } from '../../services/auth.service';
import { WorkerUser } from '../../model/WorkerUser';
import { UserService } from '../../services/user.service';
import { Category } from '../../model/Category';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit{
  title = 'JavaSampleApproach';
  fileUpload: String;// = Server.routeTo(Routes.PICTURE) + this.authService.user.username;// "http://localhost:4200/api/upload/files/user";
  asd: String;
  description = 'Angular4-SpringBosot Demo';
  value = '';
  tiles = [
    {text: 'One', cols: 1, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 1, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
  ];
  //ng for mögé  [colspan]="tile.cols" [rowspan]="tile.rows" 
  categories: Category[];
  workers : WorkerUser[];

  constructor(private authService: AuthService, private userService : UserService, private categoryService: CategoryService) {
    this.fileUpload = Server.routeTo(Routes.PICTURE); // + "user";
    this.asd = Server.routeTo(Routes.PICTURE + 'cat/');
  }
  ngOnInit()
  {
    this.userService.getWorkers().subscribe(workers => {
      this.workers = workers;
    });
    this.categoryService.getCategories().subscribe(cat => {
      this.categories = cat;
    });
  }  
  //consturctorban a servicet meghívni
  submit(){
   /* this.searchservice.search(this.value)
      .subscribe(
        res => ...
      )*/
      console.log("ez a list" + this.workers.length);
      console.log("keresed ezt" + this.value);
  }

}
