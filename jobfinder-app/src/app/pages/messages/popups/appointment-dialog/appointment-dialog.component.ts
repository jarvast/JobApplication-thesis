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
  
  @Component({
    selector: 'app-appointment-dialog',
    templateUrl: './appointment-dialog.component.html',
    styleUrls: ['./appointment-dialog.component.css']
  })
  export class AppointmentDialogComponent implements OnInit {
  
    form: FormGroup;
    message : Message = new Message();
    receiver: UserUser | WorkerUser;
    isRateable: boolean;
    ratedBy: Rating[];
    
    constructor(private messageService: MessageService,
      private formBuilder: FormBuilder,
      private authService: AuthService,
      private taskService: TasksService,
      public dialog : MatDialog,
      private snackBar: MatSnackBar,
      public dialogRef: MatDialogRef<AppointmentDialogComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any) {
        this.receiver = data.receiver;

        }
  
    ngOnInit() {
      this.form = this.formBuilder.group({
        date: ['',Validators.required],
        content: ['', Validators.required]
      });
    }
  
    get subject() {
      return this.form.get('subject')
    }
    get content() {
      return this.form.get('content')
    }
  
    submit(){
      /*this.messageService.send(new Message(this.receiver,null, this.subject.value, this.content.value,null,false)).subscribe();
      this.dialogRef.close();*/
    }
  }
  
