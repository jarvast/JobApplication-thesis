import { Role } from "./Role";

export class User {
    username: String;
    password: String;
    role: Role;

    
  constructor(username?: String, password?: String, role?: Role) {
    this.username = username || "";
    this.password = password || "";
    this.role=role;
    }
}