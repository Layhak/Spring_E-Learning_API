package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(
        @NotNull(message = "Title is required")
        @NotBlank(message = "Title is required")

        String title,

        @NotBlank(message = "Alias is required")
        @NotNull(message = "Alias is required")
        String alias,

        Long categoryId,

        String description,

        Long instructorId,

        @NotBlank(message = "Thumbnail is required")
        @NotNull(message = "Thumbnail is required")

        String thumbnail
) {
}
