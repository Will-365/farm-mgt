package rw.minagri.farmmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rw.minagri.farmmanagement.model.ResetToken;
import rw.minagri.farmmanagement.model.User;

import java.util.Optional;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Long> {
    void deleteByToken(String token);
    Optional<ResetToken> findByUser(User user);
    Optional<ResetToken> findByToken(String token);
}