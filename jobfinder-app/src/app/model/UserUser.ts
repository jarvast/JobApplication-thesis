import { User } from "./User";
import { Location } from "./Location";
import { Role } from "./Role";

export class UserUser {
  id: number;
  name: String;
  email: String;
  phoneNum: String;
  location: Location;
  imgName: String;
  role:Role;

    
  constructor(id?: number, name?: String, email?: String, phoneNum?: String, location?: Location, imgName?: String,role?:Role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNum = phoneNum;
    this.location = location;
    this.imgName = imgName;
    this.role= role;
    }
}