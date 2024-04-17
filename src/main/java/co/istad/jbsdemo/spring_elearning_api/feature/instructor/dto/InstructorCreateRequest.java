package co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record InstructorCreateRequest(

        String biography,
        String github,
        String jobTitle,
        Boolean isBlocked,
        String linkedIn,
        String website,
        String username,
        Long userId
) {
}
