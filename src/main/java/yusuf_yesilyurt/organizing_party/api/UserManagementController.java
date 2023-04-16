package yusuf_yesilyurt.organizing_party.api;

import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import yusuf_yesilyurt.organizing_party.model.AuthLoginPost200Response;
import yusuf_yesilyurt.organizing_party.model.AuthRegisterPostRequest;
import yusuf_yesilyurt.organizing_party.model.User;

@Controller
public class UserManagementController implements UserManagementApi {

    @Override
    public ResponseEntity<AuthLoginPost200Response> authLoginPost(AuthRegisterPostRequest authRegisterPostRequest) {
        // Implement the login logic here and return the appropriate response
        // return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.ok(new AuthLoginPost200Response().token("token"));
    }

    @Override
    public ResponseEntity<Void> authRegisterPost(AuthRegisterPostRequest authRegisterPostRequest) {
        // Implement the registration logic here and return the appropriate response
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> usersUserIdDelete(Integer userId) {
        // Implement the user deletion logic here and return the appropriate response
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<User> usersUserIdGet(Integer userId) {
        // Implement the user retrieval logic here and return the appropriate response
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
