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
import { FavoriteListComponent } from "./pages/favorite-list/favorite-list.component";
import { MessagesComponent } from "./pages/messages/messages.component";
import { EditAppointmentsComponent } from "./pages/edit-appointments/edit-appointments.component";
import { AdminDashboardComponent } from "./pages/admin-dashboard/admin-dashboard.component";
import { RegisterUserComponent } from "./pages/register-user/register-user.component";
import { RegisterWorkerComponent } from "./pages/register-worker/register-worker.component";

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
            {path: 'myuser/:id', component: EditUserProfileComponent, data: {roles: ["USER"]}},
            {path: 'myworker/:id', component: EditWorkerProfileComponent, data: {roles: ["WORKER"]}},
            {path: 'mytasks/:id', component: EditTasksComponent, data: {roles: ["WORKER"]}},
            {path: 'myfavorites/:id', component: FavoriteListComponent, data: {roles: ["USER"]}},
            {path: 'mymessages/:id', component: MessagesComponent, data: {roles: ["WORKER","USER","ADMIN"]}},
            {path: 'myappointments/:id', component: EditAppointmentsComponent, data: {roles: ["WORKER"]}},
            {path: 'dashboard/:id',component:AdminDashboardComponent, data: {roles: ["ADMIN"]} },
            {path: 'registeruser', component: RegisterUserComponent},
            {path: 'registerworker', component: RegisterWorkerComponent},
            {path: '**', component: LoginComponent}
        ]
    }
]