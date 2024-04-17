package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.base.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/")
    public co.istad.jbsdemo.spring_elearning_api.base.BaseResponse<StudentResponse> createStudent(@Validated @RequestBody StudentCreateRequest request) {
        return BaseResponse.<StudentResponse>createSuccess()
            .setPayload(studentService.createNewStudent(request));
    }

}
