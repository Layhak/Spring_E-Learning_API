package co.istad.jbsdemo.spring_elearning_api.feature.instructor;

import co.istad.jbsdemo.spring_elearning_api.domain.Instructor;
import co.istad.jbsdemo.spring_elearning_api.domain.User;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.user.UserRepository;
import co.istad.jbsdemo.spring_elearning_api.mapper.InstructorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final UserRepository userRepository;

    @Override
    public InstructorResponse createNew(InstructorCreateRequest instructorCreateRequest) {
//        check is instructor already exists
        if (instructorRepository.existsById(instructorCreateRequest.userId())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This user already exists!"
            );
        }

        Instructor instructor = instructorMapper.createInstructorFromRequest(instructorCreateRequest);
        instructorRepository.save(instructor);
        return instructorMapper.instructorToResponse(instructor);
    }

    @Override
    public Page<InstructorResponse> getList(int page, int size) {
        // validate page and size
        if(page < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page must be greater than or equal to zero");
        }

        if(size < 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Size must be greater than or equal to one");
        }

        Sort sortByInstName = Sort.by(Sort.Direction.ASC, "jobTitle");
        PageRequest pageRequest = PageRequest.of(page, size, sortByInstName);

        Page<Instructor> instructors = instructorRepository.findAll(pageRequest);

        return instructors.map(instructorMapper::instructorToResponse);
    }

    @Override
    public InstructorResponse findInstructorProfile(String username) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() ->
                        new NoSuchElementException("There is no instructor with username = " + username));

        Instructor instructor = user.getInstructor();

        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found for user with username: " + username);
        }

        return instructorMapper.instructorToResponse(instructor);
    }

    @Override
    public InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest) {
        User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("There is no user with username = " + username));

        Instructor instructor = user.getInstructor();

        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found for user with username: " + username);
        }

        instructorMapper.updateInstructorFromRequest(instructor,instructorUpdateRequest);
        return instructorMapper.instructorToResponse(instructorRepository.save(instructor));
    }

}
