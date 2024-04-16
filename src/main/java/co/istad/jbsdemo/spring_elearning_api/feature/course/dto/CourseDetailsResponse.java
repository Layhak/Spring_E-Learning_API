package co.istad.jbsdemo.spring_elearning_api.feature.course.dto;

public record CourseDetailsResponse(
        Long id,
        String title,
        String alias,
        Long categoryId,
        String description,
        Long instructorId,
        Boolean isDeleted,
        Boolean isFree,
        String thumbnail
) {
}
