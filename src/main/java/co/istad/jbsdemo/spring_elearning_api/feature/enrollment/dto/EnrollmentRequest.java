package co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto;

import java.time.LocalDate;

public record EnrollmentRequest(
        String code,
        LocalDate enrolledAt,
        Boolean isDeleted,
        Long courseId,
        Long studentId
) {
}
