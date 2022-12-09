package dev.cybercivizen.dognet.controller;

import dev.cybercivizen.dognet.dto.UserPreviewDTO;
import dev.cybercivizen.dognet.mapper.MapStructMapper;
import dev.cybercivizen.dognet.model.Post;
import dev.cybercivizen.dognet.model.User;
import dev.cybercivizen.dognet.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO: Implement ResponseEntity to make the API somewhat Restful
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    public UserController(UserRepository userRepository, MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, name = "Save a user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/users/{usersIds}", method = RequestMethod.GET, name = "Retrieve a user or list of users")
    public Object getUser(@PathVariable Long[] usersIds) {
        if (usersIds.length == 1) {
            return userRepository.findById(usersIds[0]);
        } else {
            return userRepository.findAllById(List.of(usersIds));
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, name = "Retrieve a list of all users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{usersIds}", method = RequestMethod.DELETE, name = "Delete a user or a list of users")
    public void deleteUser(@PathVariable Long[] usersIds) {
        if (usersIds.length == 1) {
            userRepository.deleteById(usersIds[0]);
        } else {
            userRepository.deleteAllById(List.of(usersIds));
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, name = "Modify user information")
    public Optional<User> updateUser(@RequestBody User newUser) {
        return userRepository.findById(newUser.getId())
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    user.setCountry(newUser.getCountry());
                    user.setPictureFilePath(newUser.getPictureFilePath());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setCreationDate(newUser.getCreationDate());
                    return userRepository.save(user);
                });
    }

    @RequestMapping(value = "/users/{userId}/posts", method = RequestMethod.GET, name = "Retrieve user's posts")
    public Iterable<Post> getAllUserPosts(@PathVariable Long userId) {
        return userRepository.findAllPostsById(userId);
    }
}
