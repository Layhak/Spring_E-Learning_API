package co.istad.jbsdemo.spring_elearning_api.feature.instructor;

import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    @Operation(summary = "Create a new instructor", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = InstructorCreateRequest.class), examples = @ExampleObject(value = """
            {
              "biography": "Sou",
              "github": "sou@gmail.com",
              "jobTitle": "Gamer",
              "isBlocked": true,
              "linkedIn": "sou@gmail.com",
              "website": "sou@gmail.com",
              "userId" : 0
            }
            """))))
    public void createInstructor(@Validated @RequestBody InstructorCreateRequest request) {
        instructorService.createNew(request);
    }

    @GetMapping
    @Operation(summary = "Get list of instructor")
    BaseResponse<PageResponse<InstructorResponse>> findList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size) {
        return BaseResponse.<PageResponse<InstructorResponse>>ok().setPayload(instructorService.getList(page, size));

    }

    @GetMapping("/{username}")
    @Operation(summary = "Find instructor by name")
    public InstructorResponse findInstructorByUsername(@PathVariable String username) {
        return instructorService.findInstructorProfile(username);
    }

    @PutMapping("/{username}")
    @Operation(summary = " Update instructor’s information", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = InstructorUpdateRequest.class), examples = @ExampleObject(value = """
            {
                  "biography": "Sou",
                  "github": "sou@gmail.com",
                  "jobTitle": "Gamer",
                  "isBlocked": true,
                  "linkedIn": "sou@gmail.com",
                  "website": "sou@gmail.com"
            }
            """))))
    public void updateInstructorProfile(@PathVariable String username, @RequestBody InstructorUpdateRequest request) {
        instructorService.updateInstructorProfile(username, request);
    }
}
