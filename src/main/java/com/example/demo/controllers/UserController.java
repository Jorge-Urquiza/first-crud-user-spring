package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> index() {
        List<User> users = this.userService.getAll();
        return users.isEmpty() ?
                ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        User user =  this.userService.getById(id);
        return user == null ?
                    ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name) {
        List<User> users =  this.userService.getUserByName(name);
        return users.isEmpty() ?
                ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }
    @PostMapping("")
    public User store(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return this.userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.userService.destroy(id);
    }
}
