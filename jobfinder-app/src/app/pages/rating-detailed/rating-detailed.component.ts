import { Component, OnInit, Input } from '@angular/core';
import { RatingsService } from '../../services/ratings.service';
import { Rating } from '../../model/Rating';

@Component({
  selector: 'app-rating-detailed',
  templateUrl: './rating-detailed.component.html',
  styleUrls: ['./rating-detailed.component.css']
})
export class RatingDetailedComponent implements OnInit {

  @Input() workerId: number;
  ratings : Rating[];

  constructor(private ratingService: RatingsService) { }

  ngOnInit() {
    this.ratingService.getAllRatingsByWorker(this.workerId).subscribe(res => {
      this.ratings=res;
      console.log("raéétét" + this.ratings);
    })
  }

}
