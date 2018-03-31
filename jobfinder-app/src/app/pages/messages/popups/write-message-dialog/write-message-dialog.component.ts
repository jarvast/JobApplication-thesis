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

@Component({
  selector: 'app-write-message-dialog',
  templateUrl: './write-message-dialog.component.html',
  styleUrls: ['./write-message-dialog.component.css']
})
export class WriteMessageDialogComponent implements OnInit {

  form: FormGroup;
  message : Message = new Message();
  receiver: UserUser | WorkerUser;
  isRateable: boolean;
  ratedBy: Rating[];
  
  constructor(private messageService: MessageService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private ratingService: RatingsService,
    public dialog : MatDialog,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<WriteMessageDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.receiver = data.receiver;
      console.log(this.receiver)
      if (this.authService.user.role.role == "WORKER" && this.receiver.role.role == "USER"){
        this.ratingService.getAllRatingsByWorker(this.authService.user.id).subscribe(data =>{
          this.ratedBy= data;
          for (let rater of this.ratedBy){
            if (rater.sender.id == this.receiver.id){
              this.isRateable = false;
              //console.log("false" + rater.sender.id + this.message.sender.id)
              break;
            }else{
              this.isRateable=true;
              //console.log("true"  + rater.sender.id + this.message.sender.id)
            }
          }
          //this.isWorker = true;
        })
      }
      }

  ngOnInit() {
    this.form = this.formBuilder.group({
      subject: ['',Validators.required],
      content: ['', Validators.required]
    });
  }

  get subject() {
    return this.form.get('subject')
  }
  get content() {
    return this.form.get('content')
  }
  requestRating(){
      this.messageService.requestRating(this.receiver.id).subscribe(data =>{
        this.openSnackBarOk();
      });
  }
openSnackBarOk() {
this.snackBar.open('Az értékelési kérelmét elküldtük!','Rendben' ,{
  duration: 3000,
});
}

  submit(){
    this.messageService.send(new Message(this.receiver,null, this.subject.value, this.content.value,null,false)).subscribe();
    this.dialogRef.close();
  }
}
