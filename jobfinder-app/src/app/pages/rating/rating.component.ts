import { Component, OnInit, Input } from '@angular/core';
import { RatingsService } from '../../services/ratings.service';
import { isNumber } from 'util';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  @Input() workerId: number; 
  rating : any;
  starNumber : any[];
  max : number;

  constructor(private rateService: RatingsService) {
    /*for(var i=0;i<this.max; i++){
      console.log("--" + i)
      this.starNumber.push(i);
    }*/
   }

  ngOnInit() {
    this.rateService.getRating(this.workerId).subscribe(res =>{
      if (isNaN(res.rating)){
        this.rating = "Még nem érkezett értékelés"
      }else{
        this.rating = res.rating;
        this.max = Math.round(res.rating);
        console.log(this.max + "max");
        this.starNumber =[];
        for (var i=0;i<this.max; i++){
          this.starNumber.push(i);
        }
      }
      //this.rating = res.rating;
    });
    
  }

}
