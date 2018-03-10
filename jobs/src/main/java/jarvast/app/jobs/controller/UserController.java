package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController<T> {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<T> login(HttpServletRequest http) {
        return ResponseEntity.ok((T) userService.getLoggedInUser());
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        userService.logout();
        return ResponseEntity.ok(204);
    }
    
    @GetMapping("/workers")
    public ResponseEntity<List<Worker>> getWorkers(){
        return ResponseEntity.ok(userService.getWorkers());
    }

}
