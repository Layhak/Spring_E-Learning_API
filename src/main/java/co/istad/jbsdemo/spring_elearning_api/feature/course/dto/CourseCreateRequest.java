package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

public record CourseCreateRequest(
        String title,
        String description,
        String thumbnail,
        String status,
        String createdBy
) {
}
