package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record StudentUpdateRequest(
        @NotBlank(message = "HighSchool is required")
        String highSchool,
        @NotBlank(message = "University is required")
        String university,
        @NotBlank(message = "Status is required")
        Boolean isBlocked

) {
}
