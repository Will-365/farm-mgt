package rw.minagri.farmmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.minagri.farmmanagement.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameContainingOrEmailContaining(String username, String email);
    List<User> findByUsernameContaining(String username);
    List<User>findByEmailContaining(String email);
    List<User> findTop5ByOrderByIdDesc();
}
