 import { Component, OnInit, Inject } from '@angular/core';
  import { MessageService } from '../../../../services/message.service';
  import { AuthService } from '../../../../services/auth.service';
  import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatSnackBar } from '@angular/material';
  import { Message } from '../../../../model/Message';
  import { UserUser } from '../../../../model/UserUser';
  import { WorkerUser } from '../../../../model/WorkerUser';
  import { FormGroup, FormBuilder, Validators } from '@angular/forms';
  import { RatingsService } from '../../../../services/ratings.service';
  import { Rating } from '../../../../model/Rating';
import { TasksService } from '../../../../services/tasks.service';
import { Task } from '../../../../model/Task';
import { AppointmentService } from '../../../../services/appointment.service';
import { Appointment } from '../../../../model/Appointment';
  
  @Component({
    selector: 'app-appointment-dialog',
    templateUrl: './appointment-dialog.component.html',
    styleUrls: ['./appointment-dialog.component.css']
  })
  export class AppointmentDialogComponent implements OnInit {
  
    form: FormGroup;
    worker: WorkerUser;
    tasks : Task[];
    appointments: Appointment[];
    isEmpty: boolean = false;
    date: Date;
    
    constructor(private messageService: MessageService,
      private formBuilder: FormBuilder,
      private authService: AuthService,
      private taskService: TasksService,
      private appointmentService: AppointmentService,
      public dialog : MatDialog,
      private snackBar: MatSnackBar,
      public dialogRef: MatDialogRef<AppointmentDialogComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any) {
        this.worker = data.receiver;
        this.taskService.getTasks(this.worker.id).subscribe(tasks =>{
          this.tasks = tasks;
        });
        this.appointmentService.getAppointments(this.worker.id).subscribe(apps =>{
          this.appointments = apps;
          if (this.appointments.length ==0){
            this.isEmpty = true;
          }
        });


        }
  
    ngOnInit() {
      this.form = this.formBuilder.group({
        appointment: ['',Validators.required],
        task: ['', Validators.required],
        comment: ['']
      });
    }
  
    get appointment() {
      return this.form.get('appointment')
    }
    get task() {
      return this.form.get('task')
    }
    get comment() {
      return this.form.get('comment')
    }
    openSnackBarOk() {
      this.snackBar.open('A foglalási kérelmét elküldtük!','Rendben' ,{
        duration: 3000,
      });
    }
  
    submit(){
      this.date = this.appointment.value.appDate;
      var day = new Date(this.date).toLocaleDateString();
      let content = "Az üzenet feladójától időpontfoglalási kérelme érkezett, kérjük reagáljon a kérelemre az alábbi gombokkal!\n Választott időpont: " + day + " " + this.appointment.value.appTime
       + ".\n Kívánt feladat: " + this.task.value.taskName + ".\n Egyéb megjegyzés: " + this.comment.value;
      this.messageService.send(new Message(this.worker ,null, "Időpontkérés", content,null,false,false,true, this.appointment.value)).subscribe();
      this.dialogRef.close();
    }
  }
  
