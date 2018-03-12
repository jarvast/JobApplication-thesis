import { Routes } from "@angular/router";
import { RouteGuard } from "./route.guard";
import { LoginComponent } from "./pages/login/login.component";
import { HelpComponent } from "./pages/help/help.component";
import { WorkerListComponent } from "./pages/worker-list/worker-list.component";

export const appRoutes: Routes = [
    {
        path:'',
        canActivateChild: [RouteGuard],
        children: [
            {path: '', redirectTo:'help', pathMatch:'full'},
            {path: 'login', component: LoginComponent},
            {path: 'help', component: HelpComponent},
            {path: 'categories/:id', component: WorkerListComponent},
        ]
    }
]