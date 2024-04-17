package co.istad.jbsdemo.spring_elearning_api.feature.enrollment;

import co.istad.jbsdemo.spring_elearning_api.base.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.enrollment.dto.EnrollmentResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create enrollment")
    public BaseResponse<EnrollmentResponse> createEnrollment(@Valid @RequestBody EnrollmentRequest enrollmentRequest) {
        return BaseResponse.<EnrollmentResponse>createSuccess()
            .setPayload(enrollmentService.createEnrollment(enrollmentRequest));
    }

//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
//    @Operation(summary = "Get all enrollment")
//    public Page<EnrollmentResponse> getAllEnrollment(
//            @RequestParam(required = false, defaultValue = "0") int page,
//            @RequestParam(required = false, defaultValue = "2") int limit) {
//        return enrollmentService.getAllEnrollment(page, limit);
//    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get enrollment by code")
    public BaseResponse<Optional<EnrollmentDetailsResponse>> getEnrollmentByCode(@PathVariable String code) {
        return BaseResponse.<Optional<EnrollmentDetailsResponse>>ok()
            .setPayload(enrollmentService.getByCode(code));
    }

    @PutMapping("/{code}/progress")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update progress")
    public BaseResponse<EnrollmentProgressResponse> updateProgress(@Valid @PathVariable String code, @Valid @RequestBody Integer progress) {
        return BaseResponse.<EnrollmentProgressResponse>updateSuccess()
            .setPayload(enrollmentService.updateProgress(code, progress));
    }

    @GetMapping("/{code}/progress")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get progress by code")
    public BaseResponse<Optional<Integer>> getProgressByCode(@PathVariable String code) {
        return BaseResponse.<Optional<Integer>>ok()
            .setPayload(enrollmentService.getProgressByCode(code));
    }

    @PutMapping("/{code}/is-certified")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Certify progress")
    public BaseResponse<EnrollmentProgressResponse> certifyProgress(@Valid @PathVariable String code) {
        return BaseResponse.<EnrollmentProgressResponse>updateSuccess()
            .setPayload(enrollmentService.certifyProgress(code));
    }

    @PutMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Disable enrollment")
    public BaseResponse<EnrollmentResponse> disableEnrollment(@Valid @PathVariable String code) {
        return BaseResponse.<EnrollmentResponse>updateSuccess()
            .setPayload(enrollmentService.disable(code));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all enrollment pagination and filter")
    public BaseResponse<PageResponse<EnrollmentResponse>> getAllEnrollment(@RequestParam Map<String, String> params){
        return BaseResponse.<PageResponse<EnrollmentResponse>>ok()
                .setPayload(enrollmentService.getAllEnrollment(params));
    }

}
