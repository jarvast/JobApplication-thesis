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
    MatSnackBarModule,
    MatGridListModule,
    MatListModule
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
      MatSnackBarModule,
      MatGridListModule,
      MatListModule
],
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
      MatSnackBarModule,
      MatGridListModule,
      MatListModule],
  })
  export class MaterialItemsModule {
  }