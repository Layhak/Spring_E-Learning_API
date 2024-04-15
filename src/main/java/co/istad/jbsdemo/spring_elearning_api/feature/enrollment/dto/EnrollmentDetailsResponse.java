package co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.domain.Student;

import java.time.LocalDate;

public record EnrollmentDetailsResponse(
        Long id,
        String code,
        LocalDate certifiedAt,
        LocalDate enrolledAt,
        Boolean isCertified,
        Boolean isDeleted,
        Integer progress,
        Course course,
        Student student
) {
}
