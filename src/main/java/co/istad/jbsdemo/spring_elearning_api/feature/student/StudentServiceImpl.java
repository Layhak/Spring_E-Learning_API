package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import co.istad.jbsdemo.spring_elearning_api.domain.User;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.user.UserRepository;
import co.istad.jbsdemo.spring_elearning_api.mapper.StudentMapper;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserRepository userRepository;

    @Override
    public StudentResponse createNewStudent(StudentCreateRequest studentCreateRequest) {

        if (studentRepository.existsById(studentCreateRequest.userId())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This user already exists!"
            );
        }

        Student student = studentMapper.createStudentFromRequest(studentCreateRequest);
        return studentMapper.studentToResponse(studentRepository.save(student));
    }

    @Override
    public PageResponse<StudentResponse> getList(int page, int size) {
        // validate page and size
        if (page < 0 || size <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page and limit must be greater than 0");
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<StudentResponse> students = studentRepository.findAll(pageable).map(studentMapper::studentToResponse);

        return new PageResponse<>(students);
    }

    @Override
    public StudentResponse findStudentProfile(String username) {
        String name = username.toLowerCase();
        Student student = studentRepository.findByHighSchool(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + name + " not found"));

        return studentMapper.studentToResponse(student);
    }
    @Override
    public StudentResponse updateStudentProfile(String username, StudentUpdateRequest studentUpdateRequest) {
        String name = username.toLowerCase().replace(" ", "-");
        Student student = studentRepository.findByHighSchool(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + name + " not found"));

        student.setHighSchool(studentUpdateRequest.highSchool());
        student.setUniversity(studentUpdateRequest.university());
        student.setIsBlocked(studentUpdateRequest.isBlocked());

        studentRepository.save(student);

        return studentMapper.studentToResponse(student);
    }
}
