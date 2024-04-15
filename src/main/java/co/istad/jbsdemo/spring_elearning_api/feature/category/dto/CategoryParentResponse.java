package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

import java.util.List;

public record CategoryParentResponse(
    Long id,
    String name,
    List<CategoryResponse> subcategories
) {
}
