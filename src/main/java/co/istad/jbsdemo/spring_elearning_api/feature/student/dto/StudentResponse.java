package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;


import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;

public record StudentResponse(
        Long id,
        String highSchool,
        String university,
        Boolean isBlocked,
        UserDetailsResponse user
        ) {

}
