import { User } from "./User";
import { UserUser } from "./UserUser";

export class Rating {
    sender: UserUser;
    content: String;
    rating: number;

    
  constructor(sender?: UserUser, content?: String, rating?:number) {
    this.sender = this.sender;
    this.content= content;
    this.rating = rating;
    }
}