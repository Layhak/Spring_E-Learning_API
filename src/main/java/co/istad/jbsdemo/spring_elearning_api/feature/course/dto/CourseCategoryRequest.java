package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

import jakarta.validation.constraints.NotNull;

public record CourseCategoryRequest(
        @NotNull
        String alias
) {
}
