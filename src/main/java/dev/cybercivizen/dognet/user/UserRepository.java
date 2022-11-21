package dev.cybercivizen.dognet.user;

import dev.cybercivizen.dognet.post.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long userId);
    Iterable<User> findAllById(Iterable<Long> usersIds);
    Iterable<User> findAll();
    <S extends User> S save(S user);
    void deleteById(Long userId);
    void deleteAllById(Iterable<? extends Long> usersIds);
    @Query(value = "select * from post p join user u ON user_id = :userId", nativeQuery = true)
    Iterable<Post> findAllPostsById(Long userId);

}
