package dev.cybercivizen.dognet.user;

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

}
