import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Role } from '../../model/Role';
import { User } from '../../model/User';
import { Server, Routes } from '../../utils/ServerRoutes';


interface MenuItem {
  link: String;
  title: String;
  att?: any;
}

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  imgRoute:String;
  cachebuster: number;

  private common: MenuItem[] = [
    {link: '/help', title: 'Szakember regisztráció'},
    {link: '/help', title: 'Felhasználó regisztráció'}
  ];

  private asdo : MenuItem[] = [
    {link: "/asd", title: 'dsadsa'},
    {link: '/mymessages', title: 'Üzeneteim'}
  ];
  
  private roleMenus = new Map<String, MenuItem[]>([
    ["ADMIN", [...this.asdo]],
    ["USER", [...this.asdo , {link: '/user', title: 'Profilom'}, {link: '/favorites', title: 'Kedvenceim'}]],
    ["WORKER", [...this.asdo, {link: '/worker', title: 'Profilom'}, {link: '/mytasks', title: 'Feladataim'}]]
]);

  
  menus: MenuItem[];
  rolemenu: MenuItem[];

  constructor(private authService: AuthService, private router: Router) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
   }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setMenus()
      }
    })
    this.menus = this.common;
  }
  setMenus() {
    if (this.authService.isLoggedIn) {
      this.rolemenu = this.roleMenus.get(this.authService.user.role.role);
    }
    this.cachebuster=Date.now();
  }
    logout(){
      this.authService.logout().subscribe(res =>{
        this.authService.isLoggedIn=false;
        this.authService.user= new User();
        this.router.navigate(['/login']);
      })
    }
    getTimeStamp(){
       return this.cachebuster;
     }
}

