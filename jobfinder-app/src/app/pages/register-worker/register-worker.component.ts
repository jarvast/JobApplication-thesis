import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { LocationService } from '../../services/location.service';
import { MatSnackBar } from '@angular/material';
import { CategoryService } from '../../services/category.service';
import { Location } from '../../model/Location';
import { WorkerUser } from '../../model/WorkerUser';
import { Category } from '../../model/Category';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-worker',
  templateUrl: './register-worker.component.html',
  styleUrls: ['./register-worker.component.css']
})
export class RegisterWorkerComponent implements OnInit {

  form: FormGroup;
  form2: FormGroup;
  form3: FormGroup;
  locations: Location[];
  categories: Category[];
  newWorker: WorkerUser;

  constructor(private userService: UserService, private fb:FormBuilder,private locationService: LocationService, private snackBar: MatSnackBar,private categoryService: CategoryService, private router:Router) { 
    this.locationService.getAllLocations().subscribe(res =>{
      this.locations=res;
    });
    this.categoryService.getCategories().subscribe(data =>{
      this.categories = data;
    })
    this.form = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required],
    });
    this.form2 = this.fb.group({
      fullname: ['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      phone: ['',Validators.required]
    });
    this.form3 = this.fb.group({
      location: ['',Validators.required],
      category: ['',Validators.required],
      description: ['',Validators.required]
    });

  }

  ngOnInit() {

  }
  get username() {
    return this.form.get('username')
  }
  get password() {
    return this.form.get('password')
  }
  get phone() {
    return this.form2.get('phone')
  }
  get email() {
    return this.form2.get('email')
  }
  get fullname() {
    return this.form2.get('fullname')
  }
  get location() {
    return this.form3.get('location')
}

get category() {
  return this.form3.get('category')
}
get description() {
  return this.form3.get('description')
}
  submit(){
    //newworker: WorkerUser;
    this.userService.newWorker(new WorkerUser(this.username.value,'',this.fullname.value,this.phone.value,this.category.value,this.description.value,"Worker"), this.password.value).subscribe(data =>{
      this.newWorker = data;
      this.locationService.updateLocations(this.location.value, this.newWorker.id).subscribe(res => {
      });
      this.openSnackBarOk();
      this.router.navigate(['/login']);
    },err=>{
      this.openSnackBarErr();
    })
  }
  openSnackBarOk() {
    this.snackBar.open('Siker','Rendben' ,{
      duration: 3000,
    });
  }
  openSnackBarErr() {
    this.snackBar.open('NEM','Rendben' ,{
      duration: 3000,
    });
  }

}
