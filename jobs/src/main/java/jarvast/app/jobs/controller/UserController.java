package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<User> login(HttpServletRequest http) {
        //System.out.println(userService.getLoggedInUser().toString());
        System.out.println("getloggedinsuer" + userService.getLoggedInUser());
            return ResponseEntity.ok(userService.getLoggedInUser());
        
       /* SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("TE VAGY" + context.getAuthentication().getName());*/
        //return 200 ha ok, return 401 ha nem
       /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getCredentials());*/
        // return ResponseEntity.ok(204);
    }
    
    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("logout előtt ez van bent" + context.getAuthentication().getName());
        userService.logout();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        //System.out.println("logoutcsakserviceben" + userService.getLoggedInUser().getUsername());
        return ResponseEntity.ok(204);
    }
    
}
