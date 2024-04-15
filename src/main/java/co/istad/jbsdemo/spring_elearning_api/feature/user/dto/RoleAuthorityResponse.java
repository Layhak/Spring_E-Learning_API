package co.istad.jbsdemo.spring_elearning_api.feature.user.dto;

import co.istad.jbsdemo.spring_elearning_api.domain.Authority;
import co.istad.jbsdemo.spring_elearning_api.domain.Role;

public record RoleAuthorityResponse(
        Role role,
        Authority authority
) {
}
