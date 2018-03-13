import { Component, OnInit, Input } from '@angular/core';
import { LocationService } from '../../services/location.service';
import { Location } from '../../model/Location';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {

  @Input() workerId: number;
  locations : Location[];
  stringy : String[];
  commad : String ="";

  constructor(private locationService: LocationService) { }

  ngOnInit() {
    this.locationService.getLocations(this.workerId).subscribe(res => {
      this.locations = res;
      this.locations.join(', ');
      this.stringy = [];
      for (let entry of this.locations){
        this.stringy.push(entry.location);
      }
      this.commad= this.stringy.join(', ');
    });
  }

}
