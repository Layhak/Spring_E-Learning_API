package co.istad.jbsdemo.spring_elearning_api.feature.student;

import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import co.istad.jbsdemo.spring_elearning_api.domain.User;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.user.UserRepository;
import co.istad.jbsdemo.spring_elearning_api.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        User user = userRepository.findById(studentCreateRequest.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));

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
    public Page<StudentResponse> getList(int page, int size) {
        // validate page and size
        if(page < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page must be greater than or equal to zero");
        }

        if(size < 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Size must be greater than or equal to one");
        }
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Student> students = studentRepository.findAll(pageRequest);

        return students.map(studentMapper::studentToResponse);
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
