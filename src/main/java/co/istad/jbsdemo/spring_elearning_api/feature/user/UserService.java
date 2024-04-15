package co.istad.jbsdemo.spring_elearning_api.feature.user;

import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;

import java.util.List;

public interface UserService {
    List<UserDetailsResponse> getAllUser();
    UserDetailsResponse getByUsername(String username);
    UserDetailsResponse disableUser(String username);
    UserDetailsResponse enableUser(String username);
    void deleteUser(String username);
}
