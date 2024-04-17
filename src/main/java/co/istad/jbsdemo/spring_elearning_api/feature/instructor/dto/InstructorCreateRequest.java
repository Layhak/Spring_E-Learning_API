package co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record InstructorCreateRequest(
        @NotBlank(message = "Biography is required")
        String biography,
        String github,
        String jobTitle,
        Boolean isBlocked,
        String linkedIn,
        String website,
        @NotNull
        Long userId
) {
}
