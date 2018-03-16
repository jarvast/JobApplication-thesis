import { User } from "./User";

export class UserUser {
  id: number;
  name: String;
  email: String;
  phoneNum: String;
  location: String;
  imgName: String;

    
  constructor(id?: number, name?: String, email?: String, phoneNum?: String, location?: String, imgName?: String) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNum = phoneNum;
    this.location = location;
    this.imgName = imgName;
    }
}