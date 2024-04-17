package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface StudentService {
    StudentResponse createNewStudent(StudentCreateRequest studentCreateRequest);
    Page<StudentResponse> getList(int page, int size);
    StudentResponse findStudentProfile(String username);
    StudentResponse updateStudentProfile(String username, StudentUpdateRequest studentUpdateRequest);
}
