package co.istad.jbsdemo.spring_elearning_api.feature.user;

import co.istad.jbsdemo.spring_elearning_api.base.BaseResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserRequest;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new User", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserRequest.class), examples = @io.swagger.v3.oas.annotations.media.ExampleObject(value = """
                   {
                            "familyName": "familyName",
                            "givenName": "givenName",
                            "email" : "username@mail.com",
                            "gender": "male",
                            "password": "password",
                            "nationalIdCard": "111111111",
                            "username": "username",
                            "phoneNumber": "phoneNumber",
                            "profile": "profile",
                            "address1": "address1",
                            "address2": "address2",
                            "cityId": 1,
                            "roles": ["Student"]
                   }
            """))))
    public BaseResponse<UserDetailsResponse> createNew(@RequestBody UserRequest userRequest) {
        return BaseResponse.<UserDetailsResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all user")
    public BaseResponse<List<UserDetailsResponse>> getAll() {
        return BaseResponse.<List<UserDetailsResponse>>ok()
                .setPayload(userService.getAllUser());
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get by username")
    public BaseResponse<UserDetailsResponse> getByUsername(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>ok()
                .setPayload(userService.getByUsername(username));
    }

    @PutMapping("/{username}/disable")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Disable user")
    public BaseResponse<UserDetailsResponse> disableUser(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>updateSuccess()
                .setPayload(userService.disableUser(username));
    }

    @PutMapping("/{username}/enable")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Enable user")
    public BaseResponse<UserDetailsResponse> enableUser(@PathVariable String username) {
        return BaseResponse.<UserDetailsResponse>updateSuccess()
                .setPayload(userService.enableUser(username));
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete by username")
    public BaseResponse<UserDetailsResponse> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return BaseResponse.<UserDetailsResponse>deleteSuccess().setMessage("User deleted successfully!");

    }

}
