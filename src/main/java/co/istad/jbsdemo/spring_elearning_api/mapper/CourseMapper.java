package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "instructorId", source = "instructor.id")
    CourseDetailsResponse mapCourseToCourseDetailsResponse(Course course);

    Course mapCourseDetailsResponseToCourse(CourseDetailsResponse courseDetailsResponse);

    Course courseRequestToCourse(CourseRequest courseRequest);


}