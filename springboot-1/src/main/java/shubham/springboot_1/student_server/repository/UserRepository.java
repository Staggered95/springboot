package shubham.springboot_1.student_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shubham.springboot_1.student_server.entity.User;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

}