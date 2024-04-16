package co.istad.jbsdemo.spring_elearning_api.feature.instructor;

import co.istad.jbsdemo.spring_elearning_api.domain.Instructor;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.mapper.InstructorMapper;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Override
    public InstructorResponse createNew(InstructorCreateRequest instructorCreateRequest) {
//        check is instructor already exists
        if (instructorRepository.existsById(instructorCreateRequest.userId())) {
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
    public PageResponse<InstructorResponse> getList(int page, int size) {
        // validate page and size
        if (page < 0 || size <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page and limit must be greater than 0");
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<InstructorResponse> instructors = instructorRepository.findAll(pageable).map(instructorMapper::instructorToResponse);

        return new PageResponse<>(instructors);
    }

    @Override
    public InstructorResponse findInstructorProfile(String username) {

        String name = username.toLowerCase();
        Instructor instructor = instructorRepository.findByBiography(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + name + " not found"));

        return instructorMapper.instructorToResponse(instructor);
    }

    @Override
    public InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest) {

        String name = username.toLowerCase().replace(" ", "-");
        Instructor instructor = instructorRepository.findByBiography(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + name + " not found"));

        instructor.setBiography(instructorUpdateRequest.biography());
        instructor.setGithub(instructorUpdateRequest.github());
        instructor.setIsBlocked(instructorUpdateRequest.isBlocked());
        instructor.setJobTitle(instructorUpdateRequest.jobTitle());
        instructor.setLinkedIn(instructorUpdateRequest.linkedIn());
        instructor.setWebsite(instructorUpdateRequest.website());

        instructorRepository.save(instructor);

        return instructorMapper.instructorToResponse(instructor);
    }
}

