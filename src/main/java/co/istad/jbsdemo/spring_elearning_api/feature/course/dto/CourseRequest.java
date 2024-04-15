package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

public record CourseRequest(
        String title,
        String description,
        String thumbnail,
        String status,
        String createdBy,
        String updatedBy
) {
}
