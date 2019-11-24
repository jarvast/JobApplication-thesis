package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Admin;
import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.CategoryService;
import jarvast.app.jobs.service.UserNotFoundException;
import jarvast.app.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

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

    @GetMapping("/workers/all")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(userService.getAllWorkers());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/workers/{categoryName}")
    private ResponseEntity<Iterable<Worker>> listByCategory(@PathVariable(value = "categoryName") String categoryName) {
        Category category = categoryService.findByCategoryId(Long.parseLong(categoryName));
        return ResponseEntity.ok(userService.listByCategory(category));
    }

    @GetMapping("/workers/search/{searchword}")
    private ResponseEntity<Iterable<Worker>> searchforWorkers(@PathVariable(value = "searchword") String searchword) {
        return ResponseEntity.ok(userService.searchForString(searchword));
    }

    @GetMapping("/workers/maintain")
    private ResponseEntity maintain() {
        userService.maintain();
        return ResponseEntity.ok(200);
    }

    @GetMapping("/worker/{id}")
    private ResponseEntity<Worker> getWorker(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.getWorker(id));
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return (ResponseEntity<User>) ResponseEntity.badRequest();
    }

    @PostMapping("/user")
    private ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return (ResponseEntity<User>) ResponseEntity.badRequest();
    }

    @PostMapping("/worker")
    private ResponseEntity<Worker> updateUser(@RequestBody Worker worker) {
        return ResponseEntity.ok(userService.updateWorker(worker));
    }

    @GetMapping("/workers/top")
    private ResponseEntity<Iterable<Worker>> getTop5Workers() {
        return ResponseEntity.ok(userService.getTop5());
    }

    @GetMapping("/favorite/{id}")
    private ResponseEntity<User> favorite(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.favorite(id));
    }

    @GetMapping("/favorite/remove/{id}")
    private ResponseEntity<User> removeFavorite(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.removeFavorite(id));
    }

    @GetMapping("/favorite")
    private ResponseEntity<List<Worker>> listFavorites() {
        return ResponseEntity.ok(userService.listFavorites());
    }

    @GetMapping("/worker/approve/{id}")
    private ResponseEntity<Worker> approve(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(userService.approve(id));
    }

    @DeleteMapping("/worker/delete/{id}")
    private ResponseEntity deleteWorker(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(204);
    }

    @PostMapping("/new/admin")
    private ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin, HttpServletRequest request) throws NoSuchAlgorithmException {

        final String auth = request.getHeader("pass");

        String base64Credentials = auth.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] temp = md.digest(credentials.getBytes());
        credentials = String.format("%032X", new BigInteger(1, temp));

        return ResponseEntity.ok(userService.registerAdmin(admin, credentials));
    }

    @PostMapping("/new/user")
    private ResponseEntity<User> registerUser(@RequestBody User user, HttpServletRequest request) throws NoSuchAlgorithmException {

        final String auth = request.getHeader("pass");

        String base64Credentials = auth.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] temp = md.digest(credentials.getBytes());
        credentials = String.format("%032X", new BigInteger(1, temp));

        return ResponseEntity.ok(userService.registerUser(user, credentials));
    }

    @PostMapping("/new/worker")
    private ResponseEntity<Worker> registerWorker(@RequestBody Worker worker, HttpServletRequest request) throws NoSuchAlgorithmException {

        final String auth = request.getHeader("pass");

        String base64Credentials = auth.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                StandardCharsets.UTF_8);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] temp = md.digest(credentials.getBytes());
        credentials = String.format("%032X", new BigInteger(1, temp));

        return ResponseEntity.ok(userService.registerWorker(worker, credentials));
    }

}
