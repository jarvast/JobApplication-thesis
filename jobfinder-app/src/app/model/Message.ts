import { User } from "./User";
import { UserUser } from "./UserUser";
import { WorkerUser } from "./WorkerUser";

export class Message {
    id:number;
    receiver: UserUser | WorkerUser;
    sender: UserUser | WorkerUser;
    subject: String;
    content: String;
    sendTimestamp: Date;
    isSeen: boolean;
    isRatingRequest: boolean;

    
  constructor(receiver?: UserUser | WorkerUser,sender?: UserUser | WorkerUser, subject?: String, content?: String,sendTimestamp?:Date,isSeen?:boolean,isRatingRequest?:boolean,id?:number) {
    this.id = id;
    this.receiver = receiver;
    this.sender = sender;
    this.subject= subject;
    this.content = content;
    this.sendTimestamp = this.sendTimestamp;
    this.isSeen = isSeen;
    this.isRatingRequest = isRatingRequest;
    }
}