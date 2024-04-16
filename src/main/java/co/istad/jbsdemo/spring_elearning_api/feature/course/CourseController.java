package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    @Operation(summary = "Find all courses by pagination")
    BaseResponse<PageResponse<CourseDetailsResponse>> findList(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int limit) {
        return BaseResponse.<PageResponse<CourseDetailsResponse>>ok().setPayload(courseService.findAllCourses(page, limit));
    }

    @GetMapping("/{alias}")
    @Operation(summary = "Find a course detail by alias")
    BaseResponse<CourseDetailsResponse> findByAlias(@PathVariable String alias) {
        return BaseResponse.<CourseDetailsResponse>ok().setPayload(courseService.findCourseByAlias(alias));
    }

}
