import { User } from "./User";
import { Location } from "./Location";

export class UserUser {
  id: number;
  name: String;
  email: String;
  phoneNum: String;
  location: Location;
  imgName: String;

    
  constructor(id?: number, name?: String, email?: String, phoneNum?: String, location?: Location, imgName?: String) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNum = phoneNum;
    this.location = location;
    this.imgName = imgName;
    }
}