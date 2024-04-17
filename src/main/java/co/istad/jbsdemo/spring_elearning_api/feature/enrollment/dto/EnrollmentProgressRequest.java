package co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EnrollmentProgressRequest(
        @NotNull(message = "Code required")
        String code,
        LocalDate certifiedAt,
        LocalDate enrolledAt,
        Boolean isCertified,
        Boolean isDeleted,
        Integer progress,
        @NotNull(message = "Course id required")
        Long courseId,
        @NotNull(message = "Student id required")
        Long studentId
) {
}
