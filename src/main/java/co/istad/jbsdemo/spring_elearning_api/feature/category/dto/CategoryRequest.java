package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

public record CategoryRequest(
        String name,
        String alias,
        String description,
        Long parentCategoryId
) {
}
