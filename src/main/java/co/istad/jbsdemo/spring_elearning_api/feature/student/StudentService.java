package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import org.springframework.stereotype.Service;


public interface StudentService {
    StudentResponse createNewStudent(StudentCreateRequest studentCreateRequest);

}
