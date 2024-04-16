package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(
        @NotNull
        @NotBlank
        @Min(3)
        @Max(255)
        String title,
        String alias,
        Long categoryId,
        String description,
        Long instructorId,
        String thumbnail
) {
}
