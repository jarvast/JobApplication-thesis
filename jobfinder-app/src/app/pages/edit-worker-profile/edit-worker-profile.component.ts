import { Component, OnInit } from '@angular/core';
import { WorkerUser } from '../../model/WorkerUser';
import { Server, Routes } from '../../utils/ServerRoutes';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { Location } from '../../model/Location';
import { AuthService } from '../../services/auth.service';
import { LocationService } from '../../services/location.service';

@Component({
  selector: 'app-edit-worker-profile',
  templateUrl: './edit-worker-profile.component.html',
  styleUrls: ['./edit-worker-profile.component.css']
})
export class EditWorkerProfileComponent {

  workerId: number;
  imgRoute: String;
  locations : Location[];
  worker: WorkerUser;
  editForm: FormGroup;
  cachebuster : number;

  constructor(private route: ActivatedRoute, private userService: UserService,private authService: AuthService, private locationService:LocationService, private fb:FormBuilder, private router: Router) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
    this.route.params.subscribe(param => {
      this.workerId = param['id'];
      this.userService.getWorker(this.workerId).subscribe(res =>{
        this.worker=res;
        this.locationService.getAllLocations().subscribe(res =>{
          this.locations=res;
        });
        this.editForm = this.fb.group({
          name: ['',Validators.required],
          phone: ['', Validators.required],
          description: ['', Validators.required],
          loc: ['',Validators.required]
        });
        this.locationService.getLocations(this.workerId).subscribe(data =>{
          this.editForm.patchValue({loc: data});
        });
        this.editForm.patchValue({name: res.name, phone: res.phoneNum, description: res.description});
      })
    });
    this.cachebuster= Date.now();
  }
  
  get name() {
    return this.editForm.get('name')
  }
  get phone() {
    return this.editForm.get('phone')
  }
  get description() {
    return this.editForm.get('description')
  }
  get loc() {
    return this.editForm.get('loc')
}

submit() {
  this.worker.name=this.name.value;
  this.worker.phoneNum=this.phone.value;
  this.worker.description=this.description.value;
  this.userService.updateWorker(this.worker).subscribe();
  this.locationService.updateLocations(this.loc.value, this.worker.id).subscribe();
  this.router.navigate(['/worker', this.workerId]);
  }
  getTimeStamp(){
    return this.cachebuster;
  }

}
