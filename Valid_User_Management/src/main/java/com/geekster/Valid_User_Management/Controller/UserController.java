package com.geekster.Valid_User_Management.Controller;

import com.geekster.Valid_User_Management.Model.User;
import com.geekster.Valid_User_Management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ControllerAdvice
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        return userService.AddUser(user);
    }
    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }
        return user;
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUserInfo")
    public User updateUserInfo(@Valid @RequestBody User user) {
        User updatedUser = userService.updateUserInfo(user);
        if (updatedUser == null) {
            return null;
        }
        return updatedUser;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUser(userId);
    }
}