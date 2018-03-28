export class Task {
    taskName: String;
    taskPrices: String;
    id:number;

    
  constructor(taskName?: String, taskPrices?: String,id?:number) {
    this.taskName = taskName;
    this.taskPrices= taskPrices;
    this.id=id;
    }
}