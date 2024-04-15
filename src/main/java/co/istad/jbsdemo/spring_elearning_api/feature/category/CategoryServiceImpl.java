package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.domain.Category;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import co.istad.jbsdemo.spring_elearning_api.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Page<CategoryResponse> getCategories(int page, int limit) {
        //? PageRequest.of(page, limit) is a static factory method to create a new PageRequest with the given page number, size, and sort.
        PageRequest pageRequest = PageRequest.of(page, limit);
        //? findAll(pageRequest) is a method from JpaRepository that returns all entities in the table.
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        //? map() is a method from Stream that returns a stream consisting of the results of applying the given function to the elements of this stream.
        return categories.map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public CategoryParentResponse getParentCategories() {
        return null;
    }
}
