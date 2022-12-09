package dev.cybercivizen.dognet.repository;

import dev.cybercivizen.dognet.model.Reply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends CrudRepository<Reply, Long> {
}
