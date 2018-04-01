export class Appointment {
    appdate: Date;
    apptime: String;
    id:number;

    
  constructor(appdate?: Date, apptime?: String,id?:number) {
    this.appdate = appdate;
    this.apptime= apptime;
    this.id=id;
    }
}