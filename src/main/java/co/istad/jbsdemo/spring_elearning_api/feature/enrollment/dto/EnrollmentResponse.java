package co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.domain.Student;

import java.time.LocalDate;

public record EnrollmentResponse(
        Long id,
        String code,
        LocalDate enrolledAt,
        Boolean isDeleted,
        Course course,
        Student student
) {
}
