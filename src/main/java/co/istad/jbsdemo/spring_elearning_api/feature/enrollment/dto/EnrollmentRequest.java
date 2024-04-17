package co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EnrollmentRequest(
        @NotNull(message = "Code required")
        String code,
        LocalDate enrolledAt,
        @NotNull()
        Boolean isDeleted,
        @NotNull(message = "Course id required")
        Long courseId,
        @NotNull(message = "Student id required")
        Long studentId
) {
}
