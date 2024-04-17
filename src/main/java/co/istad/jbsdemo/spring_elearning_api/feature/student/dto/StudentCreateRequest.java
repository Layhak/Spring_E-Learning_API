package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;

import jakarta.validation.constraints.NotNull;

public record StudentCreateRequest(
        @NotNull(message = "not null")
        String highSchool,
        @NotNull(message = "not null")
        String university,
        @NotNull(message = "not null")
        Boolean isBlocked,
        Long userId
        ) {
}
