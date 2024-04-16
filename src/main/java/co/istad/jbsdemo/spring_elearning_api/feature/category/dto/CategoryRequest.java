package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name is required")
        String name,
        String icons,
        @NotNull(message = "Alias is required")
        @NotBlank(message = "Alias is required")
        String alias,
        @NotNull
        Long parentCategoryId
) {
}
