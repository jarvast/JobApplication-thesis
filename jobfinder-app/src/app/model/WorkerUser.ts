export class WorkerUser {
    username: String;
    password: String;
    imgName: String;

    
  constructor(username?: String, password?: String, imgName?:String) {
    this.username = username || "";
    this.password = password || "";
    this.imgName = imgName || "";
    }
}