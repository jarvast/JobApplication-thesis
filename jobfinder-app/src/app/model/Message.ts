import { User } from "./User";
import { UserUser } from "./UserUser";
import { WorkerUser } from "./WorkerUser";

export class Message {
    receiver: UserUser | WorkerUser;
    subject: String;
    content: String;
    sendTimestamp: Date;
    isSeen: boolean;

    
  constructor(receiver?: UserUser | WorkerUser, subject?: String, content?: String,sendTimestamp?:Date,isSeen?:boolean) {
    this.receiver = receiver;
    this.subject= subject;
    this.content = content;
    this.sendTimestamp = this.sendTimestamp;
    this.isSeen = isSeen;
    }
}