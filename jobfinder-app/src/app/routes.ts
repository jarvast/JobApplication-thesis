import { Routes } from "@angular/router";
import { RouteGuard } from "./route.guard";
import { LoginComponent } from "./pages/login/login.component";
import { HelpComponent } from "./pages/help/help.component";

export const appRoutes: Routes = [
    {
        path:'',
        canActivateChild: [RouteGuard],
        children: [
            {path: '', redirectTo:'help', pathMatch:'full'},
            {path: 'login', component: LoginComponent},
            {path: 'help', component: HelpComponent}
        ]
    }
]