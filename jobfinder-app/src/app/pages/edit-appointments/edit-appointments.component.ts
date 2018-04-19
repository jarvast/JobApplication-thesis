import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppointmentService } from '../../services/appointment.service';
import { MatDialog, MatTableDataSource, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Appointment } from '../../model/Appointment';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-appointments',
  templateUrl: './edit-appointments.component.html',
  styleUrls: ['./edit-appointments.component.css']
})
export class EditAppointmentsComponent implements OnInit {

  workerId: number;
  freeApps: MatTableDataSource<Appointment>;
  notFreeApps: MatTableDataSource<Appointment>;
  displayedColumns: String[] = ['appDate', 'appTime','delete'];

  constructor(private route: ActivatedRoute, private appsService: AppointmentService, public dialog: MatDialog) { 
    this.route.params.subscribe(param => {
      this.workerId = param['id'];
      this.appsService.getAppointments(this.workerId).subscribe(data =>{
        this.freeApps = new MatTableDataSource(data);
      });
      this.appsService.getOccupiedAppointments(this.workerId).subscribe(data =>{
        this.notFreeApps = new MatTableDataSource(data);
      });
    });
  }

  ngOnInit() {
  }
  deleteApp(id:number){
    this.appsService.deleteApp(id).subscribe(data =>{
      this.appsService.getAppointments(this.workerId).subscribe(data =>{
        this.freeApps = new MatTableDataSource(data);
    });
    this.appsService.getOccupiedAppointments(this.workerId).subscribe(data =>{
      this.notFreeApps = new MatTableDataSource(data);
    });
    });
  }

  openNewDialog(){
    let dialogRef = this.dialog.open(NewAppoDialog, {
      width: '250px',
      data: {id: this.workerId}
    });
    dialogRef.afterClosed().subscribe(temp =>{
      this.appsService.getAppointments(this.workerId).subscribe(data =>{
        this.freeApps = new MatTableDataSource(data);
    });
    });
  }
}
@Component({
  selector: 'new-appo-dialog',
  templateUrl: 'new-appo-dialog.html',
})
export class NewAppoDialog{

  form: FormGroup;
  workerid: number;
  minDate: Date = new Date();

  constructor(
    private formBuilder: FormBuilder,
    private appoService: AppointmentService,
    public dialogRef: MatDialogRef<NewAppoDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.workerid = data.id;
      this.form = this.formBuilder.group({
        date: ['',Validators.required],
        time: ['', Validators.required]
      });
     }

  get date() {
    return this.form.get('date')
  }
  get time() {
    return this.form.get('time')
  }
  submit(){
    this.appoService.create(new Appointment(this.date.value,this.time.value), this.workerid).subscribe();
    this.dialogRef.close();
  }
}
