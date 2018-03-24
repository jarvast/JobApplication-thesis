import { Role } from "./Role";

export class User {
    username: String;
    password: String;
    role: Role;
    imgName: String;
    id:number;

    
  constructor(username?: String, password?: String, role?: Role,imgName?: String, id?:number) {
    this.username = username || "";
    this.password = password || "";
    this.role=role;
    this.imgName = imgName;
    this.id = id;
    }
}