package yusuf_yesilyurt.organizing_party.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import yusuf_yesilyurt.organizing_party.model.AuthLoginPost200Response;
import yusuf_yesilyurt.organizing_party.model.AuthRegisterPostRequest;
import yusuf_yesilyurt.organizing_party.model.User;
import yusuf_yesilyurt.organizing_party.service.UserService;

@Controller
public class UserManagementController implements UserManagementApi {

    private final UserService userService;

    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<AuthLoginPost200Response> authLoginPost(AuthRegisterPostRequest authRegisterPostRequest) {
        User user = userService.getUserByUsername(authRegisterPostRequest.getUsername());

        if (user != null && Objects.equals(user.getPassword(), authRegisterPostRequest.getPassword())) {
            String token = UUID.randomUUID().toString();
            AuthLoginPost200Response response = new AuthLoginPost200Response()
                    .userId(user.getId())
                    .username(user.getUsername())
                    .token(token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<Void> authRegisterPost(AuthRegisterPostRequest authRegisterPostRequest) {
        User existingUser = userService.getUserByUsername(authRegisterPostRequest.getUsername());

        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        User newUser = new User()
                .username(authRegisterPostRequest.getUsername())
                .password(authRegisterPostRequest.getPassword());

        userService.saveUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> usersUserIdDelete(Integer userId) {
        Optional<User> userOptional = userService.getUserById(userId);

        if (userOptional.isPresent()) {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> usersUserIdGet(Integer userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
