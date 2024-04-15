package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record CourseCategoryRequest(
        @NotNull
        String name,
        String icons,
        @NotNull
        String alias,
        @Nullable
        Long parentCategoryId
) {
}
