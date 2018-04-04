export class Role {
    role: String;

    
  constructor(role?: String) {
    this.role = role || "GUEST";
    }
}