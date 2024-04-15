package co.istad.jbsdemo.spring_elearning_api.feature.enrollment;

import co.istad.jbsdemo.spring_elearning_api.domain.Enrollment;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentResponse;
import co.istad.jbsdemo.spring_elearning_api.mapper.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;


    @Override
    public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) {

        Enrollment enrollment = enrollmentMapper.mapToEnrollment(enrollmentRequest);

        return enrollmentMapper.mapToEnrollmentResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    public Page<EnrollmentResponse> getAllEnrollment(int page, int limit) {

        PageRequest pageRequest = PageRequest.of(page, limit);

        Page<Enrollment> users = enrollmentRepository.findAll(pageRequest);

        return users.map(enrollmentMapper::mapToEnrollmentResponse);
    }

    @Override
    public Optional<EnrollmentDetailsResponse> getByCode(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Enrollment with code %s not found!", code)));
        EnrollmentDetailsResponse enrollmentDetailsResponse = enrollmentMapper.mapToEnrollmentDetailsResponse(enrollment);
        return Optional.of(enrollmentDetailsResponse);
    }

    @Override
    public EnrollmentProgressResponse updateProgress(String code, Integer progress) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Enrollment with code %s not found!", code)));
        enrollment.setProgress(progress);
        return enrollmentMapper.mapToEnrollmentProgressResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    public Optional<Integer> getProgressByCode(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Enrollment with code %s not found!", code)));
        return Optional.of(enrollment.getProgress());
    }

    @Override
    public EnrollmentProgressResponse certifyProgress(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
                .filter(enroll -> enroll.getProgress() == 100)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Enrollment with code %s not found!", code)));
        enrollment.setIsCertified(true);
        return enrollmentMapper.mapToEnrollmentProgressResponse(enrollment);
    }

    @Override
    public EnrollmentResponse disable(String code) {
        int affectedRow = enrollmentRepository.disable(code);
        if (affectedRow > 0) {
            return enrollmentMapper.mapToEnrollmentResponse(
                enrollmentRepository.findByCode(code)
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Enrollment with code %s not found!", code))));
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Enrollment with code %s not found!", code));
        }
    }
}
