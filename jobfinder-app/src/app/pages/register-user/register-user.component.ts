import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Location } from '../../model/Location';
import { LocationService } from '../../services/location.service';
import { MatSnackBar } from '@angular/material';
import { User } from '../../model/User';
import { UserUser } from '../../model/UserUser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  form: FormGroup;
  form2: FormGroup;
  form3: FormGroup;
  passwords : FormGroup;
  locations: Location[];

  constructor(private userService: UserService, private fb:FormBuilder,private locationService: LocationService, private snackBar: MatSnackBar,private router:Router) { 
    this.locationService.getAllLocations().subscribe(res =>{
      this.locations=res;
    });
    this.form = this.fb.group({
      username: ['',Validators.required]
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
      location: ['',Validators.required]
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

checkPasswords(group: FormGroup) {
  let pass = group.controls.password.value;
  let confirmPass = group.controls.confirmPass.value;

  return pass === confirmPass ? null : { notSame: true }     
}
  submit(){
    this.userService.newUser(new UserUser(this.fullname.value,this.email.value,this.phone.value,this.location.value,null,this.username.value,"User"), this.password.value).subscribe(data =>{
      this.openSnackBarOk();
      this.router.navigate(['/login']);
    },err=>{
      this.openSnackBarErr();
    })
  }
  openSnackBarOk() {
    this.snackBar.open('Sikeresen regisztrált!','Rendben' ,{
      duration: 3000,
    });
  }
  openSnackBarErr() {
    this.snackBar.open('Sikertelen regisztráció, már létezik ilyen felhasználónév!','Értem' ,{
      duration: 3000,
    });
  }

}
