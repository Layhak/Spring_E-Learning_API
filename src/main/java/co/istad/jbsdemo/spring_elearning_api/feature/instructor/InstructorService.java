package co.istad.jbsdemo.spring_elearning_api.feature.instructor;

import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;

public interface InstructorService {

    InstructorResponse createNew(InstructorCreateRequest instructorCreateRequest);
    PageResponse<InstructorResponse> getList(int page, int size);
    InstructorResponse findInstructorProfile(String username);
    InstructorResponse updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest);

}
