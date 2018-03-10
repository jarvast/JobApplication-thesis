import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Role } from '../../model/Role';
import { User } from '../../model/User';


interface MenuItem {
  link: String;
  title: String;
}

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  private common: MenuItem[] = [
    {link: '/help', title: 'Szakember reg'},
    {link: '/help', title: 'Felhasználó reg'}
  ];

  
  menus: MenuItem[];

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setMenus()
      }
    })
  }
  setMenus() {
    if (this.authService.isLoggedIn) {
      this.menus = this.common;
    }else{
      this.menus = this.common;
    }
  }
    logout(){
      this.authService.logout().subscribe(res =>{
        this.authService.isLoggedIn=false;
        this.authService.user= new User();
        this.router.navigate(['/login']);
      })
    }
}

