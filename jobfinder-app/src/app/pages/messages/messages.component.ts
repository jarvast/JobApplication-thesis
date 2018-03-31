import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MessageService } from '../../services/message.service';
import { Message } from '../../model/Message';
import { Server, Routes } from '../../utils/ServerRoutes';
import { MatDialog } from '@angular/material';
import { MessageDialog } from './popups/message-dialog/message-dialog';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  myId: number;
  sentMessages: Message[];
  receivedMessages: Message[];
  imgRoute: String;

  constructor(private router: Router, private route: ActivatedRoute, private messageService: MessageService, public dialog: MatDialog) { 
    this.imgRoute = Server.routeTo(Routes.PICTURE);
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.myId = param['id'];
      this.messageService.getSentMessages(this.myId).subscribe(data =>{
        this.sentMessages = data;
        this.sentMessages.sort((leftSide,rightSide): number =>{
          if (leftSide.sendTimestamp > rightSide.sendTimestamp) return -1;
          if (leftSide.sendTimestamp < rightSide.sendTimestamp) return 1;
          return 0;
        });
      });
      this.messageService.getReceivedMessages(this.myId).subscribe(data =>{
          this.receivedMessages = data;
          this.receivedMessages.sort((leftSide,rightSide): number =>{
            if (leftSide.sendTimestamp > rightSide.sendTimestamp) return -1;
            if (leftSide.sendTimestamp < rightSide.sendTimestamp) return 1;
            return 0;
          });
      })
    });
  }
  openMessage(message: Message, isSent: boolean){
    let dialogRef = this.dialog.open(MessageDialog, {
      width: '30%',
      //data: { id: task.id, name: task.taskName, prices: task.taskPrices, task: task }
      data :{message:message, type:isSent}
    });
    dialogRef.afterClosed().subscribe(res =>{
      this.messageService.getSentMessages(this.myId).subscribe(data =>{
        this.sentMessages = data;
        this.sentMessages.sort((leftSide,rightSide): number =>{
          if (leftSide.sendTimestamp > rightSide.sendTimestamp) return -1;
          if (leftSide.sendTimestamp < rightSide.sendTimestamp) return 1;
          return 0;
        });
      });
  });
  }

}
