import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MessageService } from '../../services/message.service';
import { Message } from '../../model/Message';
import { Server, Routes } from '../../utils/ServerRoutes';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  myId: number;
  sentMessages: Message[];
  imgRoute: String;

  constructor(private router: Router, private route: ActivatedRoute, private messageService: MessageService) { 
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.myId = param['id'];
      this.messageService.getMessages(this.myId).subscribe(data =>{
        this.sentMessages = data;
        for (let entry of this.sentMessages){
          //console.log(entry.timestamp);
          //entry.receiver
        }
      })
    });
  }

}
