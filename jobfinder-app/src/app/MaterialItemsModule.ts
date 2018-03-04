import {
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTableModule,
    MatToolbarModule,
    MatCheckboxModule,
    MatIconModule,
    MatMenuModule,
    MatSortModule,
    MatPaginatorModule,
    MatCardModule,
    MatSnackBarModule
  } from '@angular/material';
  import {NgModule} from "@angular/core";
  
  @NgModule({
    imports: [
      MatFormFieldModule,
      MatInputModule,
      MatButtonModule,
      MatToolbarModule,
      MatTableModule,
      MatSelectModule,
      MatCheckboxModule,
      MatIconModule,
      MatMenuModule,
      MatSortModule,
      MatPaginatorModule,
      MatCardModule,
      MatSnackBarModule],
    exports: [
      MatFormFieldModule,
      MatInputModule, MatButtonModule,
      MatToolbarModule,
      MatTableModule,
      MatSelectModule,
      MatCheckboxModule,
      MatIconModule,
      MatMenuModule,
      MatSortModule,
      MatPaginatorModule,
      MatCardModule,
      MatSnackBarModule],
  })
  export class MaterialItemsModule {
  }