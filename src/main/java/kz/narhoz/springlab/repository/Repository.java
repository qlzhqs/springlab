package kz.narhoz.springlab.repository;

import kz.narhoz.springlab.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<User, Long> {
    List<User> findByEmailContainingOrderByNameDesc(String email);
    List<User> findByNameStartsWith(String name);


    // Native Query
    @Query(value = "select * from users order by surname asc",nativeQuery = true)
    List<User> findUsersByCustomQuery();

    @Query(value = "select * from users where id > :qid",nativeQuery = true)
    List<User> findGreaterId(Long qid);;

    User findByUsername(String username);
}
