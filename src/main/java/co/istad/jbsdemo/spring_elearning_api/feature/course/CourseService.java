package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import org.springframework.data.domain.Page;

public interface CourseService {
    //?Create course
    CourseDetailsResponse createCourse(CourseRequest courseRequest);

    //?Update course by alias
    CourseDetailsResponse updateCourse(String alias, CourseRequest courseRequest);

    //?Update course thumbnail by alias
    CourseDetailsResponse updateCourseThumbnailByAlias(String alias, CourseRequest courseRequest);

    //?Update course categories by alias
    CourseDetailsResponse updateCourseCategoriesByAlias(String alias, CourseRequest courseRequest);

    //?Disable course by alias
    CourseDetailsResponse disableCourseByAlias(String alias);

    //?Get course by alias
    CourseDetailsResponse getCourseByAlias(String alias);

    //?Get all courses
    Page<CourseDetailsResponse> getAllCourses(int page, int limit);
}