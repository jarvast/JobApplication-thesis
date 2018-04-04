import { Role } from "./Role";

export class AdminUser {
    username: String;
    password: String;
    name:String;
    roletype: String;

    
  constructor(username?: String, password?: String,name?:String,roletype?:String) {
    this.username = username;
    this.password= password;
    this.name=name;
    this.roletype= roletype;
    }
}