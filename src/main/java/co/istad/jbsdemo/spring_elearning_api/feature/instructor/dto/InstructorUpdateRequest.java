package co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record InstructorUpdateRequest (
        @NotBlank(message = "Biography is required")
        String biography,
        @NotBlank(message = "Github is required")
        String github,
        @NotBlank(message = "Job Title is required")
        String jobTitle,
        @NotBlank(message = "Status is required")
        Boolean isBlocked,
        @NotBlank(message = "LinkedIn is required")
        String linkedIn,
        @NotBlank(message = "Website is required")
        String website
) {
}
