import { Component, OnInit } from '@angular/core';
import { UploadFileService } from '../upload-file.service';
import { Observable } from 'rxjs/Observable';
import { Image } from '../../model/Image';

@Component({
  selector: 'list-upload',
  templateUrl: './list-upload.component.html',
  styleUrls: ['./list-upload.component.css']
})
export class ListUploadComponent implements OnInit {

  showFile = false
  fileUploads: Observable<String[]>
  file : String;
  image : Image = new Image();
 
  constructor(private uploadService: UploadFileService) {}
  ngOnInit() {
  }

  showFiles(enable: boolean) {
    this.showFile = enable
 
    if (enable) {
      //this.fileUploads = this.uploadService.getFiles();
      this.uploadService.getFiles().subscribe( res => this.image = res, err=> console.log(err));
      console.log("ezmi a " + this.image.url);
    }
    //console.log(this.fileUploads);
  }

}
