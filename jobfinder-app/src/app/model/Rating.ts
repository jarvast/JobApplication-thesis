import { UserUser } from "./UserUser";
import { WorkerUser } from "./WorkerUser";

export class Rating {
    sender: UserUser;
    receiver: WorkerUser;
    content: String;
    rating: number;
    timestamp: Date;

    
  constructor(sender?: UserUser,receiver?:WorkerUser, content?: String, rating?:number, timestamp?:Date) {
    this.sender = this.sender;
    this.content= content;
    this.rating = rating;
    this.timestamp = timestamp;
    this.receiver = receiver;
    }
}