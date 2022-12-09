package dev.cybercivizen.dognet.repository;

import dev.cybercivizen.dognet.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
