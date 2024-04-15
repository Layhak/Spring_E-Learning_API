package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategoryByAlias(String alias, CategoryRequest categoryRequest);

    CategoryResponse disableCategoryByAlias(String alias);

    CategoryResponse getCategoryByAlias(String alias);

    Page<CategoryResponse> getCategories(int page, int limit);

    List<CategoryParentResponse> getParentCategories();
}
