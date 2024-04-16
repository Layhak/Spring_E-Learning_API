package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.user.UserRepository;
import co.istad.jbsdemo.spring_elearning_api.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserRepository userRepository;
    @Override
    public StudentResponse createNewStudent(StudentCreateRequest studentCreateRequest) {
        //        check is instructor already exists
        if (studentRepository.existsById(studentCreateRequest.userId())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This user already exists!"
            );
        }

        Student student = studentMapper.createStudentFromRequest(studentCreateRequest);
        studentRepository.save(student);
        return studentMapper.studentToResponse(student);
    }
}
