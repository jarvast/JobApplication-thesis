import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, CanActivateChild, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {AuthService} from "./services/auth.service";

@Injectable()
export class RouteGuard implements CanActivate, CanActivateChild {

  constructor(private authService: AuthService,public router:Router) {
  }

  canActivate(next: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return next.data.roles == null ? true : next.data.roles.includes(this.authService.user.role.role)
  }

  canActivateChild(next: ActivatedRouteSnapshot,
                      state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.canActivate(next, state)
  }
}