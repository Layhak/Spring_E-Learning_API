package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull
        String name,
        @NotNull
        String alias,
        String description,
        Long parentCategoryId
) {
}
