package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Student;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentCreateRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.student.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = UserMapper.class)
public interface StudentMapper {

    Student createStudentFromRequest(StudentCreateRequest studentCreateRequest);
    @Mapping(target = "user", source = "student.user", qualifiedByName = "toUserResponse")
    StudentResponse studentToResponse(Student student);

}

