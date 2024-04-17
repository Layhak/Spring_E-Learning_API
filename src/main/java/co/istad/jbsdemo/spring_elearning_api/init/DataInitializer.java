package co.istad.jbsdemo.spring_elearning_api.init;


import co.istad.jbsdemo.spring_elearning_api.domain.Role;
import co.istad.jbsdemo.spring_elearning_api.feature.role.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//populate data (role with some data)
@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;

    @PostConstruct
    void roleInit() {
        List<String> roles = List.of("Admin", "Instructor", "Student");
        if (roleRepository.findAll().isEmpty()) {
            for (String role : roles) {
                Role roleObj = new Role();
                roleObj.setName(role);
                roleRepository.save(roleObj);
            }
        }
    }

}
