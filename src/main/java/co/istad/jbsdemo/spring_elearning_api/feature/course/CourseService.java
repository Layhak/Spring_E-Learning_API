package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseCategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseThumbnailRequest;
import co.istad.jbsdemo.spring_elearning_api.utilities.PageResponse;

public interface CourseService {
    //?Create course
    CourseDetailsResponse createCourse(CourseRequest courseRequest);

    //?Update course by alias
    CourseDetailsResponse updateCourse(String alias, CourseRequest courseRequest);

    //?Update course thumbnail by alias
    CourseDetailsResponse updateCourseThumbnailByAlias(String alias, CourseThumbnailRequest request);

    //?Update course categories by alias
    CourseDetailsResponse updateCourseCategoriesByAlias(String alias, CourseCategoryRequest request);

    //?Disable course by alias
    CourseDetailsResponse disableCourseByAlias(String alias);

    //?Get course by alias
    CourseDetailsResponse findCourseByAlias(String alias);

    //?Get all courses
    PageResponse<CourseDetailsResponse> findAllCourses(int page, int limit);
}