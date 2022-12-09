package dev.cybercivizen.dognet.repository;

import dev.cybercivizen.dognet.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long postId);
    List<Post> findAll();
    Iterable<Post> findByUserId(Long userId);
    <S extends Post> S save(S post);
    void deleteById(Long postId);
}
