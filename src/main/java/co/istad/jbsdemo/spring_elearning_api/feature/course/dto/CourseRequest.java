package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

public record CourseRequest(
        String title,
        String alias,
        Long categoryId,
        String description,
        Long instructorId,
        String thumbnail
) {
}
