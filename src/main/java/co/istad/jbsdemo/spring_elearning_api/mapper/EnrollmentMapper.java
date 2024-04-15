package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Enrollment;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentResponse mapToEnrollmentResponse(Enrollment enrollment);
    Enrollment mapToEnrollment(EnrollmentRequest enrollmentRequest);
    EnrollmentDetailsResponse mapToEnrollmentDetailsResponse(Enrollment enrollment);
    EnrollmentProgressResponse mapToEnrollmentProgressResponse(Enrollment enrollment);
}
