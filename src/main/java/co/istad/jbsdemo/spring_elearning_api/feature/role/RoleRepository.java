package co.istad.jbsdemo.spring_elearning_api.feature.role;

import co.istad.jbsdemo.spring_elearning_api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
