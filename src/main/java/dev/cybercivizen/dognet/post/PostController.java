package dev.cybercivizen.dognet.post;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET, name = "Retrieve a post by id")
    public Optional<Post> getPost(@PathVariable Long postId) {
        return postRepository.findById(postId);
    }

    @RequestMapping(value = "/posts/user/{userId}", method = RequestMethod.GET, name = "Retrieve posts by a user id")
    public Iterable<Post> getPostsByUser(@PathVariable Long userId) {
        return postRepository.findByUserId(userId);
    }
}
