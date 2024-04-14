package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

public record CategoryResponse(
        Long id,
        String name,
        String alias,
        String description,
        CategoryParentResponse parentCategory
) {
}
