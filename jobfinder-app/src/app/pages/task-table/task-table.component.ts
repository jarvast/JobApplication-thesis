import { Component, OnInit, Input } from '@angular/core';
import { TasksService } from '../../services/tasks.service';
import { Task } from '../../model/Task';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-task-table',
  templateUrl: './task-table.component.html',
  styleUrls: ['./task-table.component.css']
})
export class TaskTableComponent implements OnInit {

  @Input() workerId: number;
  tasks: MatTableDataSource<Task>;
  displayedColumns: String[] = ['taskName', 'taskPrices'];

  constructor(private taskService: TasksService) { }

  ngOnInit() {
    this.taskService.getTasks(this.workerId).subscribe(res =>{
      this.tasks = new MatTableDataSource(res);
    });
  }

}
