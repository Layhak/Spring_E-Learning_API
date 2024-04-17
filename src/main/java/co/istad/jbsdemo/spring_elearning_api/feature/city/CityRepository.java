package co.istad.jbsdemo.spring_elearning_api.feature.city;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c ORDER BY c.name ASC")
    List<City> findAllByOrderByNameAsc();

    List<City> findByCountry_Iso(String iso);
}