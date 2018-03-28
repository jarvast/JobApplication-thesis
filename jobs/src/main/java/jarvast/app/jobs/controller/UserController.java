package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.CategoryService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController<T> {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

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
    public ResponseEntity<List<Worker>> getWorkers() {
        return ResponseEntity.ok(userService.getWorkers());
    }

    @GetMapping("/workers/{categoryName}")
    private ResponseEntity<Iterable<Worker>> listByCategory(@PathVariable(value = "categoryName") String categoryName) {
        Category category = categoryService.findByCategoryName(categoryName);
        return ResponseEntity.ok(userService.listByCategory(category));
    }

    @GetMapping("/workers/search/{searchword}")
    private ResponseEntity<Iterable<Worker>> searchforWorkers(@PathVariable(value = "searchword") String searchword) {
        return ResponseEntity.ok(userService.searchForString(searchword));
    }

    @GetMapping("/worker/{id}")
    private ResponseEntity<Worker> getWorker(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.getWorker(id));
    }
    @GetMapping("/user/{id}")
    private ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PostMapping("/user")
    private ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @PostMapping("/worker")
    private ResponseEntity<Worker> updateUser(@RequestBody Worker worker) {
        return ResponseEntity.ok(userService.updateWorker(worker));
    }
    
    @GetMapping("/workers/top")
    private ResponseEntity<Iterable<Worker>> getTop5Workers(){
        return ResponseEntity.ok(userService.getTop5());
    }
    @GetMapping("/favorite/{id}")
    private ResponseEntity<User> favorite(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.favorite(id));
    }
    @GetMapping("/favorite/remove/{id}")
    private ResponseEntity<User> removeFavorite(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.removeFavorite(id));
    }
    @GetMapping("/favorite")
    private ResponseEntity<List<Worker>> listFavorites(){
        return ResponseEntity.ok(userService.listFavorites());
    }

}
