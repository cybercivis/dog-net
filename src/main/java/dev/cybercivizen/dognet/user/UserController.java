package dev.cybercivizen.dognet.user;

import dev.cybercivizen.dognet.post.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
