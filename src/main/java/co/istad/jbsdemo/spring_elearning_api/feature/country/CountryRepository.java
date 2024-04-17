package co.istad.jbsdemo.spring_elearning_api.feature.country;

import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
@Query("SELECT c FROM Country c ORDER BY c.name ASC")
    List<Country> findAllByOrderByNameAsc();
}
