import { UserUser } from "./UserUser";

export class Rating {
    sender: UserUser;
    content: String;
    rating: number;
    timestamp: Date;

    
  constructor(sender?: UserUser, content?: String, rating?:number, timestamp?:Date) {
    this.sender = this.sender;
    this.content= content;
    this.rating = rating;
    this.timestamp = timestamp;
    }
}