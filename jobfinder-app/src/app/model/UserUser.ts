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
  role: Role;
  username: String;
  roletype: String;

    
  constructor(name?: String, email?: String, phoneNum?: String, location?: Location, imgName?: String,username?:String,roletype?:String,role?:Role,id?: number) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNum = phoneNum;
    this.location = location;
    this.imgName = imgName;
    this.role= role;
    this.username = username;
    this.roletype = roletype;
    }
}