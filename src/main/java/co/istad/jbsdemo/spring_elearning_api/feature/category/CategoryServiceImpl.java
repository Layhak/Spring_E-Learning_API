package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.domain.Category;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import co.istad.jbsdemo.spring_elearning_api.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        if (categoryRepository.existsByName(categoryRequest.name())) {
            // Throw exception here
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category with name " + categoryRequest.name() + " already exists");
        }

        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        category.setAlias(categoryRequest.name().toLowerCase().replace(" ", "-"));
        category.setIsDeleted(false);
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public CategoryResponse getCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return List.of();
    }

    @Override
    public CategoryParentResponse getParentCategories() {
        return null;
    }
}
