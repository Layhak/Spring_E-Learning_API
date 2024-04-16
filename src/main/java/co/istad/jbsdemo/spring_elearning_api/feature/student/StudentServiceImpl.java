package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.user.UserRepository;
import co.istad.jbsdemo.spring_elearning_api.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserRepository userRepository;

    @Override
    public StudentResponse createNewStudent(StudentCreateRequest studentCreateRequest) {
        Student student = studentMapper.createStudentFromRequest(studentCreateRequest);
        return studentMapper.studentToResponse(studentRepository.save(student));
    }
}
