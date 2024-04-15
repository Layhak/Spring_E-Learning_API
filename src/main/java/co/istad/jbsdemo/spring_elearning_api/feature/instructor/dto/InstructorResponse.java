package co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto;

import lombok.Builder;

@Builder
public record InstructorResponse(
        Long id,
        String biography,
        String github,
        String jobTitle,
        String linkedIn,
        String website,
        String isBlocked,
        Long userId
) {
}
