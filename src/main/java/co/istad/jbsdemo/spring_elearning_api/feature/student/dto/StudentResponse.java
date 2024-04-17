package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.User;

public record StudentResponse(
        Long id,
        String highSchool,
        String university,
        Boolean isBlocked,
        User user
        ) {

}
