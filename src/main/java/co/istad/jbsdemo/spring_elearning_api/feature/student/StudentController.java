package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.base.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/")
    @Operation(summary = "Create a new student")
    public co.istad.jbsdemo.spring_elearning_api.base.BaseResponse<StudentResponse> createStudent(@Validated @RequestBody StudentCreateRequest request) {
        return BaseResponse.<StudentResponse>createSuccess()
            .setPayload(studentService.createNewStudent(request));
    }

    @GetMapping("/")
    @Operation(summary = "Find all students by pagination")
    Page<StudentResponse> findList(@RequestParam(required = false, defaultValue = "0") int page,
                                   @RequestParam(required = false, defaultValue = "5") int size){
        return studentService.getList(page, size);
    }
    @GetMapping("/{highSchool}")
    @Operation(summary = "Find a student's profile")
    public ResponseEntity<StudentResponse> findStudentProfile(@PathVariable String username) {
        StudentResponse studentResponse = studentService.findStudentProfile(username);
        return ResponseEntity.ok(studentResponse);
    }

    @PutMapping("/{highSchool}")
    @Operation(summary = "Update a student's profile")
    public ResponseEntity<StudentResponse> updateStudentProfile(@PathVariable String username,
                                                                @Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        StudentResponse updatedStudent = studentService.updateStudentProfile(username, studentUpdateRequest);
        return ResponseEntity.ok(updatedStudent);
    }

}
