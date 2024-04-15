package co.istad.jbsdemo.spring_elearning_api.feature.user.dto;

import java.util.Set;

public record RoleResponse(
        Long id,
        String name,
        Set<String> authorities
) {
}