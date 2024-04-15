package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDetailsResponse mapCourseToCourseDetailsResponse(Course course);

    Course mapCourseDetailsResponseToCourse(CourseDetailsResponse courseDetailsResponse);

}
