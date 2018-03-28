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
    MatListModule,
    MatTooltipModule,
    MatDialogModule,
    MatTabsModule
  } from '@angular/material';
  import {NgModule} from "@angular/core";
  
  @NgModule({
    imports: [
      MatFormFieldModule,
      MatInputModule,
      MatDialogModule,
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
      MatListModule,
      MatTooltipModule,
      MatTabsModule
],
    exports: [
      MatFormFieldModule,
      MatInputModule, MatButtonModule,
      MatToolbarModule,
      MatTableModule,
      MatSelectModule,
      MatCheckboxModule,
      MatIconModule,
      MatDialogModule,
      MatMenuModule,
      MatSortModule,
      MatPaginatorModule,
      MatCardModule,
      MatSnackBarModule,
      MatGridListModule,
      MatTooltipModule,
      MatTabsModule,
      MatListModule],
  })
  export class MaterialItemsModule {
  }