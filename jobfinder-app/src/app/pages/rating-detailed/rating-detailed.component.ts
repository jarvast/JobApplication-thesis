import { Component, OnInit, Input } from '@angular/core';
import { RatingsService } from '../../services/ratings.service';
import { Rating } from '../../model/Rating';

@Component({
  selector: 'rating-detailed',
  templateUrl: './rating-detailed.component.html',
  styleUrls: ['./rating-detailed.component.css']
})
export class RatingDetailedComponent implements OnInit {

  @Input() workerId: number;
  ratings : Rating[];
  allRatings: Rating[];
  showingAll: boolean= true;
  empty: boolean = false;

  constructor(private ratingService: RatingsService) { }

  ngOnInit() {
    this.ratingService.getAllRatingsByWorker(this.workerId).subscribe(res => {
      this.allRatings=res;
      if (this.allRatings.length > 0){
        if (this.allRatings.length > 3){
          this.ratings = this.allRatings.slice(0,3);
          this.showingAll = false;
        }else{
          this.ratings = this.allRatings;
        }
      }else{
        this.empty = true;
      }
      this.ratings = this.allRatings.slice(0,3);
    });
  }
  showAll(){
    this.ratings=this.allRatings;
    this.showingAll = true;
  }

}
