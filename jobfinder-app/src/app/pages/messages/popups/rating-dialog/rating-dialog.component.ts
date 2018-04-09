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
      }

  ngOnInit() {
    this.form = this.formBuilder.group({
      content: ['']
    });
  }
  get content() {
    return this.form.get('content')
  }

  submit(){
    this.ratingService.newRating(new Rating(null,this.receiver,this.content.value,this.value)).subscribe();
    this.dialogRef.close();
  }
}
