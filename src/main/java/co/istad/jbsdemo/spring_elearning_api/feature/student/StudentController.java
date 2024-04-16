package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public void createStudent(@Validated @RequestBody StudentCreateRequest request) {
        studentService.createNewStudent(request);
    }

}
