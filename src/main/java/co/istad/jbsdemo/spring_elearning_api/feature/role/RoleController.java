package co.istad.jbsdemo.spring_elearning_api.feature.role;

import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.RoleResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<RoleResponse>> getAll() {
        return BaseResponse.<List<RoleResponse>>ok()
            .setPayload(roleService.getAllRole());
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Optional<RoleResponse>> getByName(@PathVariable String name) {
        return BaseResponse.<Optional<RoleResponse>>ok()
            .setPayload(roleService.getByName(name));
    }

}
