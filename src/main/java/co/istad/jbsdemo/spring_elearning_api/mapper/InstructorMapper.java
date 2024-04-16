package co.istad.jbsdemo.spring_elearning_api.mapper;


import co.istad.jbsdemo.spring_elearning_api.domain.Instructor;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.instructor.dto.InstructorUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = InstructorMapper.class)
public interface InstructorMapper {

    Instructor createInstructorFromRequest(InstructorCreateRequest instructorCreateRequest);

    InstructorResponse instructorToResponse(Instructor instructor);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Instructor updateInstructorFromRequest(@MappingTarget Instructor instructor, InstructorUpdateRequest instructorUpdateRequest);
}
