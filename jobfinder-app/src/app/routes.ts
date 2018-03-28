import { Routes } from "@angular/router";
import { RouteGuard } from "./route.guard";
import { LoginComponent } from "./pages/login/login.component";
import { MainComponent } from "./pages/main/main.component";
import { WorkerListComponent } from "./pages/worker-list/worker-list.component";
import { WorkerProfileComponent } from "./pages/worker-profile/worker-profile.component";
import { UserProfileComponent } from "./pages/user-profile/user-profile.component";
import { EditUserProfileComponent } from "./pages/edit-user-profile/edit-user-profile.component";
import { EditWorkerProfileComponent } from "./pages/edit-worker-profile/edit-worker-profile.component";
import { EditTasksComponent } from "./pages/edit-tasks/edit-tasks.component";

export const appRoutes: Routes = [
    {
        path:'',
        canActivateChild: [RouteGuard],
        children: [
            {path: '', redirectTo:'main', pathMatch:'full'},
            {path: 'login', component: LoginComponent},
            {path: 'main', component: MainComponent},
            {path: 'categories/:id', component: WorkerListComponent},
            {path: 'worker/:id', component: WorkerProfileComponent},
            {path: 'user/:id', component: UserProfileComponent},
            {path: 'myuser/:id', component: EditUserProfileComponent},
            {path: 'myworker/:id', component: EditWorkerProfileComponent},
            {path: 'mytasks/:id', component: EditTasksComponent}
        ]
    }
]