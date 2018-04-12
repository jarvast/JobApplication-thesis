import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
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
  passwords : FormGroup;
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
    });
    this.passwords= this.fb.group({
        password: ['', [Validators.required]],
        confirmPass: ['', [Validators.required]]
      }, {validator: this.checkPasswords});
    this.form2 = this.fb.group({
      fullname: ['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      phone: ['',[Validators.required,Validators.pattern('^[0-9]+$')]]
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
    return this.passwords.get('password')
  }
  get confirmPass(){
    return this.passwords.get('confirmPass')
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


checkPasswords(group: FormGroup) {
  let pass = group.controls.password.value;
  let confirmPass = group.controls.confirmPass.value;

  return pass === confirmPass ? null : { notSame: true }     
}
  submit(){
    this.userService.newWorker(new WorkerUser(this.username.value,'',this.fullname.value,this.phone.value,this.category.value,this.description.value,"Worker",null,false,new Date()), this.password.value).subscribe(data =>{
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
    this.snackBar.open('Sikeres regisztráció!','Rendben' ,{
      duration: 3000,
    });
  }
  openSnackBarErr() {
    this.snackBar.open('Sikertelen regisztráció, már létezik ilyen felhasználónév!','Értem' ,{
      duration: 3000,
    });
  }

}
