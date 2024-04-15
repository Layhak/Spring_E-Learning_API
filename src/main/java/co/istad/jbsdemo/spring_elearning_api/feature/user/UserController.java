package co.istad.jbsdemo.spring_elearning_api.feature.user;

import co.istad.jbsdemo.spring_elearning_api.base.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<List<UserDetailsResponse>> getAll() {
        return BaseResponse.<List<UserDetailsResponse>>ok()
                .setPayload(userService.getAllUser());
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDetailsResponse> getByUsername(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>ok()
                .setPayload(userService.getByUsername(username));
    }

    @PutMapping("/{username}/disable")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDetailsResponse> disableUser(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>updateSuccess()
                .setPayload(userService.disableUser(username));
    }

    @PutMapping("/{username}/enable")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDetailsResponse> enableUser(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>updateSuccess()
                .setPayload(userService.enableUser(username));
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete by username")
    public BaseResponse<UserDetailsResponse> deleteUser(@PathVariable String username) {
                userService.deleteUser(username);
        return BaseResponse.deleteSuccess();
    }

}
