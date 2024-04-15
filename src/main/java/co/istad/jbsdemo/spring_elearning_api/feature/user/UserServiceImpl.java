package co.istad.jbsdemo.spring_elearning_api.feature.user;

import co.istad.jbsdemo.spring_elearning_api.domain.User;
import co.istad.jbsdemo.spring_elearning_api.feature.user.dto.UserDetailsResponse;
import co.istad.jbsdemo.spring_elearning_api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDetailsResponse> getAllUser() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::mapToUserResponse)
            .toList();
    }

    @Override
    public UserDetailsResponse getByUsername(String username) {
        return userMapper.mapToUserResponse(
            userRepository.findUserByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("User with username %s not found!", username))));
    }

    @Override
    public UserDetailsResponse disableUser(String username) {
        int affectedRow = userRepository.disable(username);
        if (affectedRow > 0) {
            return userMapper.mapToUserResponse(
                userRepository.findUserByUsername(username)
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with username %s not found!", username))));
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("User with username %s not found!", username)
            );
        }
    }

    @Override
    public UserDetailsResponse enableUser(String username) {
        int affectedRow = userRepository.enable(username);
        if (affectedRow > 0) {
            return userMapper.mapToUserResponse(
                userRepository.findUserByUsername(username)
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with username %s not found!", username))));
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("User with username %s not found!", username));
        }
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findUserByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("User with username %s not found!", username)));
        userRepository.delete(user);
    }
}
