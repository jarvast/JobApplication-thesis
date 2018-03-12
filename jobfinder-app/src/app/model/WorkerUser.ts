import { Category } from "./Category";

export class WorkerUser {
  id: number;
  username: String;
  imgName: String;
  email: String;
  name: String;
  phoneNum: String;
  category: Category;
  description: String;

    
  constructor(username?: String,  imgName?:String, id?: number, email?:String,name?:String,phoneNum?:String,category?:Category, description?:String) {
    this.username = username || "";
    this.imgName = imgName || "";
    this.id = id;
    this.email=email || "";
    this.name = name || "";
    this.phoneNum =phoneNum || "";
    this.category = category;
    this.description =description || "";

    }
}