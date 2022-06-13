package com.simplilearn.healthcareapi.users;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;
    UserRepository userRepository;

    @GetMapping(value = "/api/admin/")
    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/api/user/{id}")
    public Optional<UserEntity> findUserByUserId(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserByUserId(id);
    }

    @GetMapping(value = "/api/user", params = {"username", "password"})
    public String userLogin(@RequestParam("username") String userName, @RequestParam("password") String password) {
        return userService.getUserLogin(userName, password);
    }

    @GetMapping(value = "/api/admin/login", params = {"username"})
    public String getAdminLogin(@RequestParam("username") String userName) {
        return userService.getAdminLogin(userName);
    }

    @GetMapping(value = "/api/user/{id}/profiles")
    public UserProfile getUserProfileByUserId(@PathVariable("id") Long userId) {
        return userService.getUserProfileByUserId(userId);
    }

    @PutMapping(value = "/api/user/profiles/{id}")
    public UserProfile updateUserProfile(@PathVariable("id") Long id, @RequestBody UserProfile userProfile) {
        return userService.updateUserProfile(id, userProfile);
    }
}
