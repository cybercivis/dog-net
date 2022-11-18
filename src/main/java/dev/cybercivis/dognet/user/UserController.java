package dev.cybercivis.dognet.user;


import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }

    @GetMapping("/users/")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/test")
    public Iterable<User> getAllUsersByIds(@RequestBody Long[] usersIds) {
        return userRepository.findAllById(List.of(usersIds));
    }
}
