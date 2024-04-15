package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Authority;
import co.istad.jbsdemo.spring_elearning_api.domain.Role;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Named("toRoleResponse")
    @Mapping(target = "authorities", expression = "java(mapAuthorities(role.getAuthorities()))")
    RoleResponse mapToRoleResponse(Role role);

    default Set<String> mapAuthorities(Set<Authority> authorities) {
        return authorities.stream().map(Authority::getName).collect(Collectors.toSet());
    }

}
