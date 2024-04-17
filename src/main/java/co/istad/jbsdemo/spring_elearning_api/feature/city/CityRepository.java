package co.istad.jbsdemo.spring_elearning_api.feature.city;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c ORDER BY c.name ASC")
    List<City> findAllByOrderByNameAsc();

    List<City> findByCountry_Iso(String iso);


    @Query(value = "INSERT INTO cities (name, country_id) VALUES (:name, (SELECT id FROM countries WHERE iso = :iso))", nativeQuery = true)
    @Modifying
    @Transactional
    void insertCity(@Param("name") String name, @Param("iso") String iso);
}