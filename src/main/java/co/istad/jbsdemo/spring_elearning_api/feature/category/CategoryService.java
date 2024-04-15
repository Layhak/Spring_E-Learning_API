package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest);

    void deleteCategory(Long categoryId);

    CategoryResponse getCategory(Long categoryId);

    List<CategoryResponse> getCategories();

    CategoryParentResponse getParentCategories();
}
