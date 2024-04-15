package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);

    Optional<Category> findByAlias(String alias);

    @Query("SELECT c FROM Category c WHERE c.parentCategory IS NOT NULL")
    List<Category> findCategoriesWithSubcategories();

    boolean existsByAlias(String replace);
}