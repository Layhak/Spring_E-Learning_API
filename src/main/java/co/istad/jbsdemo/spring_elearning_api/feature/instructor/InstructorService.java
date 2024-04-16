package co.istad.jbsdemo.spring_elearning_api.feature.instructor;

import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import org.springframework.data.domain.Page;

public interface InstructorService {

    InstructorResponse createNew(InstructorCreateRequest instructorCreateRequest);
    Page<InstructorResponse> getList(int page, int size);
    InstructorResponse findInstructorProfile(String username);
    InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest);



}
