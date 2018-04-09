import { Component, OnInit } from '@angular/core';
import { Server, Routes } from '../../utils/ServerRoutes';
import { AuthService } from '../../services/auth.service';
import { WorkerUser } from '../../model/WorkerUser';
import { UserService } from '../../services/user.service';
import { Category } from '../../model/Category';
import { CategoryService } from '../../services/category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AbstractControl, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit{
  searchForm: FormGroup = new FormGroup({
    searchWord: new FormControl('', [Validators.required,Validators.minLength(3)])});
  imgRoute: String;
  categories: Category[];
  workers : WorkerUser[];

  constructor(private userService : UserService, private categoryService: CategoryService,private router : Router) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }
  ngOnInit()
  {
    this.userService.getTop5().subscribe(workers => {
      this.workers = workers;
    });
    this.categoryService.getCategories().subscribe(cat => {
      this.categories = cat;
    });
  };
  submit(){
      this.router.navigate(['/categories', "searchFor:" + this.searchWord.value]);
  }

  get searchWord(): AbstractControl {
    return this.searchForm.get('searchWord');
}

}
