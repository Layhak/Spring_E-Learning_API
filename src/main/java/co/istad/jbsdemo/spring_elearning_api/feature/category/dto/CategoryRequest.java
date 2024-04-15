package co.istad.jbsdemo.spring_elearning_api.feature.category.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull
        String name,
        String icons,
        @NotNull
        String alias,
        @Nullable
        Long parentCategoryId
) {
}
