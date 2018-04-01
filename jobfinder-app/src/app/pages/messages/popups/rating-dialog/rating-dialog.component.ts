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
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css']
})
export class RatingDialogComponent implements OnInit {

  form: FormGroup;
  message : Message = new Message();
  receiver: WorkerUser;
  isRateable: boolean;
  ratedBy: Rating[];
  value=2;
  
  constructor(private messageService: MessageService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private ratingService: RatingsService,
    public dialog : MatDialog,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<RatingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.receiver = data.receiver;
      console.log("rece" + this.receiver.name);
      /*if (this.authService.user.role.role == "WORKER" && this.receiver.role.role == "USER"){
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
      }*/
      }

  ngOnInit() {
    this.form = this.formBuilder.group({
      //rating: ['',Validators.required],
      content: ['']
    });
  }

  /*get rating() {
    return this.form.get('rating')
  }*/
  get content() {
    return this.form.get('content')
  }

  submit(){
    console.log(this.receiver.name + "eza rec")
    this.ratingService.newRating(new Rating(null,this.receiver,this.content.value,this.value)).subscribe();
    //this.ratingService.newRating(new Rating()
    this.dialogRef.close();
  }
}
