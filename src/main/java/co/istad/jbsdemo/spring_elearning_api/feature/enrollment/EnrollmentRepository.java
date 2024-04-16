package co.istad.jbsdemo.spring_elearning_api.feature.enrollment;

import co.istad.jbsdemo.spring_elearning_api.domain.Enrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>, JpaSpecificationExecutor<Enrollment> {

    Optional<Enrollment> findByCode(String code);

    @Modifying
    @Transactional
    @Query("UPDATE Enrollment e SET e.isDeleted = TRUE WHERE e.code = :code")
    int disable(String code);

}
