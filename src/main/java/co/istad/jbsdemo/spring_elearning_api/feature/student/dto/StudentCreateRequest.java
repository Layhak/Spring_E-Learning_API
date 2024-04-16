package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record StudentCreateRequest(
        String highSchool,
        String university,
        Boolean isBlocked,
        @NotNull(message = "User ID is required")
        Long userId
        ) {

}
