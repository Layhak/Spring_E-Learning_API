package co.istad.jbsdemo.spring_elearning_api.feature.role;

import co.istad.jbsdemo.spring_elearning_api.domain.Role;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.RoleResponse;
import co.istad.jbsdemo.spring_elearning_api.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{


    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getAllRole() {
        return roleRepository.findAll()
            .stream()
            .map(roleMapper::mapToRoleResponse)
            .toList();
    }

    @Override
    public Optional<RoleResponse> getByName(String name) {
        Role role = roleRepository.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Role with name %s not found!", name)));
        RoleResponse roleResponse = roleMapper.mapToRoleResponse(role);
        return Optional.of(roleResponse);
    }

}
