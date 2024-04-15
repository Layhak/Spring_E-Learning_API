package co.istad.jbsdemo.spring_elearning_api.feature.enrollment;

import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EnrollmentService {
    EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest);
    Page<EnrollmentResponse> getAllEnrollment(int page, int limit);
    Optional<EnrollmentDetailsResponse> getByCode(String code);
    EnrollmentProgressResponse updateProgress(String code, Integer progress);
    Optional<Integer> getProgressByCode(String code);
    EnrollmentProgressResponse certifyProgress(String code);
    EnrollmentResponse disable(String code);

}
