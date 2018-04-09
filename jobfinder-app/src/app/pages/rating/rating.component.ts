import { Component, OnInit, Input } from '@angular/core';
import { RatingsService } from '../../services/ratings.service';
import { isNumber } from 'util';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  @Input() inputRating: number;
  rating : any;
  starArray : any[];
  roundedRating : number;

  constructor(private rateService: RatingsService) {}

  ngOnInit() {
    if (this.inputRating===0){
      this.rating = "Még nem érkezett értékelés";
    }else{
      this.rating = Math.round(this.inputRating * 10) /10;
      this.roundedRating = Math.round(this.inputRating);
      this.starArray =[];
      for (var i=0;i<this.roundedRating; i++){
        this.starArray.push(i);
      }
    }
  }

}
