package co.istad.jbsdemo.spring_elearning_api.feature.user;

import co.istad.jbsdemo.spring_elearning_api.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);


    Optional<User> findUserByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = TRUE WHERE u.username = :username")
    int disable(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = FALSE WHERE u.username = :username")
    int enable(String username);


    boolean existsByEmail(String email);
}
