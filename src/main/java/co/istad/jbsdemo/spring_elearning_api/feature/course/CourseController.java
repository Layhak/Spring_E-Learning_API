package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @Operation(summary = "Create a new course", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CourseRequest.class), examples = @io.swagger.v3.oas.annotations.media.ExampleObject(value = """
            {
                "title": "Course 1",
                "alias": "course-1",
                "categoryId": 1,
                "description": "Description",
                "instructorId": 1,
                "thumbnail": "thumbnail"
            }
            """))))
    public BaseResponse<CourseDetailsResponse> createCourse(@Valid @RequestBody CourseRequest courseRequest) {
        return BaseResponse.<CourseDetailsResponse>createSuccess().setPayload(courseService.createCourse(courseRequest));
    }
    @GetMapping
    @Operation(summary = "Get list of courses")
    Page<CourseDetailsResponse> findList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "2") int limit) {
        return BaseResponse.<Page<CourseDetailsResponse>>ok().setPayload(courseService.getAllCourses(page, limit)).getPayload();
    }

}
