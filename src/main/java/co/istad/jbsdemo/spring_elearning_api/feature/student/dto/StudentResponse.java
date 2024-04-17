package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;


public record StudentResponse(
        Long id,
        String highSchool,
        String university,
        Boolean isBlocked
        ) {

}
