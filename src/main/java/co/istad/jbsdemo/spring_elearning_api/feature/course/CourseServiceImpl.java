package co.istad.jbsdemo.spring_elearning_api.feature.course;

import co.istad.jbsdemo.spring_elearning_api.domain.Category;
import co.istad.jbsdemo.spring_elearning_api.domain.Course;
import co.istad.jbsdemo.spring_elearning_api.feature.category.CategoryRepository;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.course.dto.CourseRequest;
import co.istad.jbsdemo.spring_elearning_api.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CategoryRepository categoryRepository;
//    private final InstructorRepository instructorRepository;

    @Override
    public CourseDetailsResponse createCourse(CourseRequest courseRequest) {
        Category category = categoryRepository.findById(courseRequest.categoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
//        Instructor instructor = instructorRepository.findById(courseRequest.instructorId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found"));

        if (courseRepository.existsByAlias(courseRequest.alias())) {
            // Throw exception
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course with alias " + courseRequest.alias() + " already exists");
        }

        Course course = courseMapper.courseRequestToCourse(courseRequest);

        course.setCategory(category);
//        course.setInstructor(instructor);
        course.setAlias(courseRequest.alias().toLowerCase().replace(" ", "-"));
        course.setIsDeleted(false);
        course.setIsFree(false);

        courseRepository.save(course);

        return courseMapper.mapCourseToCourseDetailsResponse(course);
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
        if (page < 0 || limit <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page and limit must be greater than 0");
        PageRequest pageRequest = PageRequest.of(page, limit);
        Page<Course> courses = courseRepository.findAll(pageRequest);
        return courses.map(courseMapper::mapCourseToCourseDetailsResponse);
    }
}
