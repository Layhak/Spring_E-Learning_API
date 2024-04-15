package co.istad.jbsdemo.spring_elearning_api.mapper;

import co.istad.jbsdemo.spring_elearning_api.domain.Role;
import co.istad.jbsdemo.spring_elearning_api.domain.User;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named("toUserResponse")
    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserDetailsResponse mapToUserResponse(User user);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }
}
