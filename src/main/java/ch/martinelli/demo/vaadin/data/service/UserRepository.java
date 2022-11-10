package ch.martinelli.demo.vaadin.data.service;

import ch.martinelli.demo.vaadin.data.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}