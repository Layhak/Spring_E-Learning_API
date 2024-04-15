package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    @Override
    public CourseDetailsResponse createCourse(CourseRequest courseRequest) {
        return null;
    }

    @Override
    public CourseDetailsResponse updateCourse(String alias, CourseRequest courseRequest) {
        return null;
    }

    @Override
    public CourseDetailsResponse updateCourseThumbnailByAlias(String alias, CourseRequest courseRequest) {
        return null;
    }

    @Override
    public CourseDetailsResponse updateCourseCategoriesByAlias(String alias, CourseRequest courseRequest) {
        return null;
    }

    @Override
    public CourseDetailsResponse disableCourseByAlias(String alias) {
        return null;
    }

    @Override
    public CourseDetailsResponse getCourseByAlias(String alias) {
        return null;
    }

    @Override
    public Page<CourseDetailsResponse> getAllCourses(int page, int limit) {
        return null;
    }
}
