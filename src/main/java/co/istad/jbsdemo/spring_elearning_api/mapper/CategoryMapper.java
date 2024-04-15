package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Category;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "parentCategory.id", source = "parentCategoryId")
    @Mapping(target = "id", ignore = true)
        // Ignore ID when mapping request to entity
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    @Mapping(target = "parentCategoryId", source = "parentCategory.id")
    CategoryResponse categoryToCategoryResponse(Category category);

    // This mapper method is now adjusted to ignore the subcategories as the record only takes id and name.
    @Mapping(target = "subcategories", ignore = true)
    CategoryParentResponse categoryToCategoryParentResponse(Category category);

    List<CategoryResponse> categoriesToCategoryResponses(List<Category> categories);
}
