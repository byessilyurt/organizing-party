package yusuf_yesilyurt.organizing_party.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yusuf_yesilyurt.organizing_party.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
