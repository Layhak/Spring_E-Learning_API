package co.istad.jbsdemo.spring_elearning_api.feature.user.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.City;

import java.time.LocalDate;
import java.util.Set;

public record UserDetailsResponse(
        Long id,
        String address1,
        String address2,
        LocalDate dob,
        String email,
        String familyName,
        String gender,
        String givenName,
        Boolean isDeleted,
        Boolean isVerified,
        String nationalIdCard,
        String phoneNumber,
        String profile,
        String username,
        String uuid,
        String verifiedCode,
        City city,
        Set<String> roles
) {
}
