import { Category } from "./Category";
import { Role } from "./Role";

export class WorkerUser {
  id: number;
  username: String;
  imgName: String;
  email: String;
  name: String;
  phoneNum: String;
  category: Category;
  description: String;
  rating : number;
  role: Role;
  approved: boolean;
  lastLogin: Date;
  roletype:String;

    
  constructor( username?: String,email?: String, name?: String, phoneNum?: String, category?: Category, description?: String,roletype?:String, rating?: number,approved?:boolean,lastLogin?:Date, role?:Role,imgName?:String,id?:number) {
    this.username = username || "";
    this.imgName = imgName || "";
    this.id = id;
    this.email=email || "";
    this.name = name || "";
    this.phoneNum =phoneNum || "";
    this.category = category;
    this.description =description || "";
    this.rating = rating;
    this.role = role;
    this.approved = approved;
    this.roletype= roletype;
    this.lastLogin = lastLogin;
    }
}