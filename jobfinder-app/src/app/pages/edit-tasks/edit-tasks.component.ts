import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TasksService } from '../../services/tasks.service';
import { Task } from '../../model/Task';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-edit-tasks',
  templateUrl: './edit-tasks.component.html',
  styleUrls: ['./edit-tasks.component.css']
})
export class EditTasksComponent implements OnInit {

  workerId: number;
  edites: boolean = false;

  tasks: MatTableDataSource<Task>;
  displayedColumns: String[] = ['taskName', 'taskPrices', 'edit'];

  constructor(private route: ActivatedRoute, private taskService: TasksService, private fb:FormBuilder, public dialog: MatDialog) {
    this.route.params.subscribe(param => {
      this.workerId = param['id'];
      this.taskService.getTasks(this.workerId).subscribe(data =>{
        this.tasks = new MatTableDataSource(data);
      });
    });
   }

  ngOnInit() {

  }
  openNewDialog(){
    let dialogRef = this.dialog.open(NewTaskDialog, {
      width: '300px',
      data: {id: this.workerId}
    });
    dialogRef.afterClosed().subscribe(temp =>{
      this.taskService.getTasks(this.workerId).subscribe(data =>{
        this.tasks = new MatTableDataSource(data);
    });
    });
  }

  openDialog(task: Task){
    let dialogRef = this.dialog.open(DialogEditor, {
      width: '300px',
      data :{task:task}
    });
    dialogRef.afterClosed().subscribe(res =>{
      this.taskService.getTasks(this.workerId).subscribe(data =>{
        this.tasks = new MatTableDataSource(data);
    })
  })
  }
}

@Component({
  selector: 'dialog-edit',
  templateUrl: 'dialog-edit.html',
})
export class DialogEditor implements OnInit{

  form: FormGroup;
  task: Task;

  constructor(
    private formBuilder: FormBuilder,
    private taskService: TasksService,
    public dialogRef: MatDialogRef<DialogEditor>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.task = data.task;
     }

    ngOnInit(){
      this.form = this.formBuilder.group({
        name: ['',Validators.required],
        prices: ['', Validators.required]
      });
      this.form.patchValue({name: this.task.taskName, prices: this.task.taskPrices});
    }

  get name() {
    return this.form.get('name')
  }
  get prices() {
    return this.form.get('prices')
  }

  submit() {
    this.task.taskName=this.name.value;
    this.task.taskPrices=this.prices.value;
    this.taskService.updateTask(this.task).subscribe();
    this.dialogRef.close();
  }

}

@Component({
  selector: 'new-task-dialog',
  templateUrl: 'new-task-dialog.html',
})
export class NewTaskDialog{

  form: FormGroup;
  workerid: number;

  constructor(
    private formBuilder: FormBuilder,
    private taskService: TasksService,
    public dialogRef: MatDialogRef<DialogEditor>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.workerid = data.id;
      this.form = this.formBuilder.group({
        name: ['',Validators.required],
        prices: ['', Validators.required]
      });
     }

  get name() {
    return this.form.get('name')
  }
  get prices() {
    return this.form.get('prices')
  }
  submit(){
    this.taskService.create(this.workerid, new Task(this.name.value, this.prices.value)).subscribe();
    this.dialogRef.close();
  }
}
