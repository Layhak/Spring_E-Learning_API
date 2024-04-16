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

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        if (categoryRepository.existsByName(categoryRequest.name())) {
            // Throw exception
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category with name " + categoryRequest.name() + " already exists");
        }
        if (categoryRepository.existsByAlias(categoryRequest.name().toLowerCase().replace(" ", "-"))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category with alias " + categoryRequest.name().toLowerCase().replace(" ", "-") + " already exists");
        }
        if (categoryRequest.parentCategoryId() != 0 && !categoryRepository.existsById(categoryRequest.parentCategoryId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent category with id " + categoryRequest.parentCategoryId() + " not found");
        }
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        category.setAlias(categoryRequest.name().toLowerCase().replace(" ", "-"));
        category.setIsDeleted(false);
        category.setIsDisabled(false);
        //if parentCategoryId throw wrong value ,make it null
        if (categoryRequest.parentCategoryId() == 0) {
            category.setParentCategory(null);
        }
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategoryByAlias(String alias, CategoryRequest categoryRequest) {
        String preparedAlias = alias.toLowerCase().replace(" ", "-");
        Category category = categoryRepository.findByAlias(preparedAlias).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with alias " + alias + " not found"));
        category.setName(categoryRequest.name());
        category.setIcons(categoryRequest.icons());
        category.setAlias(categoryRequest.name().toLowerCase().replace(" ", "-"));
        if (categoryRequest.parentCategoryId() == 0) {
            category.setParentCategory(null);
        } else {
            Category parentCategory = categoryRepository.findById(categoryRequest.parentCategoryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent category with id " + categoryRequest.parentCategoryId() + " not found"));
            category.setParentCategory(parentCategory);
        }
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse disableCategoryByAlias(String alias) {
        Category category = categoryRepository.findByAlias(alias).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with alias " + alias + " not found"));
        category.setIsDisabled(true);
        categoryRepository.save(category);
       return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse getCategoryByAlias(String alias) {
        String preparedAlias = alias.toLowerCase().replace(" ", "-");
        Category category = categoryRepository.findByAlias(preparedAlias).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with alias " + preparedAlias + " not found"));
        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> getCategories(int page, int limit) {
        if (page < 0 || limit < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page and limit must be greater than 0");
        }
        //? PageRequest.of(page, limit) is a static factory method to create a new PageRequest with the given page number, size, and sort.
        PageRequest pageRequest = PageRequest.of(page, limit);
        //? findAll(pageRequest) is a method from JpaRepository that returns all entities in the table.
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        //? map() is a method from Stream that returns a stream consisting of the results of applying the given function to the elements of this stream.
        return categories.map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public List<CategoryParentResponse> getParentCategories() {
        List<Category> categories = categoryRepository.findCategoriesWithSubcategories();
        if (categories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No parent categories found");
        }
        return categoryMapper.categoriesToCategoriesResponses(categories);
    }


}
