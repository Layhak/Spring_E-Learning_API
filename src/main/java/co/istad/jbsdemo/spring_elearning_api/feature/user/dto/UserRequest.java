package co.istad.jbsdemo.spring_elearning_api.feature.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserRequest(

        @NotNull
        @NotBlank
        String familyName,
        @NotNull
        @NotBlank
        String givenName,
        @Email(message = "Email format is not correct!")
        String email,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        @NotBlank
        String gender,
        @NotNull
        @NotBlank
        String nationalIdCard,
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String phoneNumber,
        String profile,
        @NotNull
        @NotBlank
        String address1,
        String address2,
        Long cityId,
        Set<String> roles
) {
}
