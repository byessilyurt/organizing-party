package yusuf_yesilyurt.organizing_party.api;

import org.springframework.stereotype.Controller;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import yusuf_yesilyurt.organizing_party.model.AuthLoginPost200Response;
import yusuf_yesilyurt.organizing_party.model.AuthRegisterPostRequest;
import yusuf_yesilyurt.organizing_party.model.User;

@Controller
public class UserManagementController implements UserManagementApi {

    private final ConcurrentHashMap<Integer, User> userMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public ResponseEntity<AuthLoginPost200Response> authLoginPost(AuthRegisterPostRequest authRegisterPostRequest) {
        Optional<User> optionalUser = userMap.values().stream()
                .filter(user -> user.getUsername().equals(authRegisterPostRequest.getUsername()))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (Objects.equals(user.getPassword(), authRegisterPostRequest.getPassword())) {
                String token = UUID.randomUUID().toString();
                AuthLoginPost200Response response = new AuthLoginPost200Response()
                        .userId(user.getId())
                        .username(user.getUsername())
                        .token(token);

                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<Void> authRegisterPost(AuthRegisterPostRequest authRegisterPostRequest) {
        Optional<User> existingUser = userMap.values().stream()
                .filter(user -> user.getUsername().equals(authRegisterPostRequest.getUsername()))
                .findFirst();

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        int newId = idCounter.getAndIncrement();
        User newUser = new User()
                .id(newId)
                .username(authRegisterPostRequest.getUsername())
                .password(authRegisterPostRequest.getPassword());

        userMap.put(newId, newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> usersUserIdDelete(Integer userId) {
        if (userMap.containsKey(userId)) {
            userMap.remove(userId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> usersUserIdGet(Integer userId) {
        User user = userMap.get(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

}
