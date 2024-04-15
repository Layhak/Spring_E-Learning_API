package co.istad.jbsdemo.spring_elearning_api.feature.role;

import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.RoleResponse;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleResponse> getAllRole();
    Optional<RoleResponse> getByName(String name);
}
