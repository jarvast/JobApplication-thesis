export class Appointment {
    appDate: Date;
    appTime: String;
    id:number;

    
  constructor(appDate?: Date, appTime?: String,id?:number) {
    this.appDate = appDate;
    this.appTime= appTime;
    this.id=id;
    }
}