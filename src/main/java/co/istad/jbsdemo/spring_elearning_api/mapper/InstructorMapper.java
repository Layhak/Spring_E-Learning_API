package co.istad.jbsdemo.spring_elearning_api.mapper;


import co.istad.jbsdemo.spring_elearning_api.domain.Instructor;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface InstructorMapper {

    Instructor createInstructorFromRequest(InstructorCreateRequest instructorCreateRequest);


    InstructorResponse instructorToResponse(Instructor instructor);


}
