import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'details-upload',
  templateUrl: './details-upload.component.html',
  styleUrls: ['./details-upload.component.css']
})
export class DetailsUploadComponent implements OnInit {

  @Input() fileUpload: String;

  constructor() { 
    this.fileUpload = "http://localhost:4200/api/upload/files/user.jpg"
  }

  ngOnInit() {
  }

}
