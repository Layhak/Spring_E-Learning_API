package co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto;

import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;
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
        UserDetailsResponse userDetailsResponse
) {
}
