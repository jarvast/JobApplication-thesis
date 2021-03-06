import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Role } from '../../model/Role';
import { User } from '../../model/User';
import { Server, Routes } from '../../utils/ServerRoutes';
import { MessageService } from '../../services/message.service';


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
  imgRoute:String;
  cachebuster: number;

  private registerButtons: MenuItem[] = [
    {link: '/registerworker', title: 'Szakember regisztráció'},
    {link: '/registeruser', title: 'Felhasználó regisztráció'}
  ];

  private common : MenuItem[] = [
    {link: '/mymessages', title: 'Üzeneteim'}
  ];
  
  private roleMenus = new Map<String, MenuItem[]>([
    ["ADMIN", [...this.common , {link: '/dashboard', title: 'Admin felület'}]],
    ["USER", [...this.common , {link: '/user', title: 'Profilom'}, {link: '/myfavorites', title: 'Kedvenceim'}]],
    ["WORKER", [...this.common, {link: '/worker', title: 'Profilom'}, {link: '/mytasks', title: 'Feladataim'}, {link: '/myappointments', title: 'Időpontjaim'}]]
]);

  
  regButtons: MenuItem[];
  rolemenu: MenuItem[];
  notifyNewMessage : boolean = true;

  constructor(private authService: AuthService, private router: Router, private messageService: MessageService) {
    this.imgRoute = Server.routeTo(Routes.PICTURE);
   }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setMenus()
      }
    })
    this.regButtons = this.registerButtons;
  }
  setMenus() {
    if (this.authService.isLoggedIn) {
      this.rolemenu = this.roleMenus.get(this.authService.user.role.role);
      this.messageService.newMessages(this.authService.user.id).subscribe(data =>{
        if (data.length==0){
          this.notifyNewMessage = false;
        }
      });
    }
    this.cachebuster=Date.now();
  }
    logout(){
      this.authService.logout().subscribe(res =>{
        this.authService.isLoggedIn=false;
        this.authService.user= new User();
        this.router.navigate(['/login']);
        this.notifyNewMessage=true;
      })
    }
    getTimeStamp(){
       return this.cachebuster;
     }
}

