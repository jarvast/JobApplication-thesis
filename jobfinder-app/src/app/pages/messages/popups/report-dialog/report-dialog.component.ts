import { Component, OnInit, Inject } from '@angular/core';
import { MessageService } from '../../../../services/message.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { UserUser } from '../../../../model/UserUser';
import { WorkerUser } from '../../../../model/WorkerUser';
import { Message } from '../../../../model/Message';

@Component({
  selector: 'app-report-dialog',
  templateUrl: './report-dialog.component.html',
  styleUrls: ['./report-dialog.component.css']
})
export class ReportDialogComponent implements OnInit {

  form: FormGroup;
  receiver: UserUser | WorkerUser;

  constructor(private messageService: MessageService,
    private formBuilder: FormBuilder,
    public dialog : MatDialog,
    public dialogRef: MatDialogRef<ReportDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.receiver = data.receiver;
    }
    
  ngOnInit() {
    this.form = this.formBuilder.group({
      content: ['',Validators.required]
    });
  }
  get content() {
    return this.form.get('content')
  }
  submit(){
    let subject = this.receiver.name + "(" + this.receiver.email + ") felhasználó jelentése";
    this.messageService.send(new Message(this.receiver,null, subject, this.content.value,null,false,false,false,null,true)).subscribe();
    this.dialogRef.close();
  }

}
