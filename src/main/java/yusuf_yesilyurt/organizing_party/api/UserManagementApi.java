/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package yusuf_yesilyurt.organizing_party.api;

import yusuf_yesilyurt.organizing_party.model.AuthLoginPost200Response;
import yusuf_yesilyurt.organizing_party.model.AuthRegisterPostRequest;
import yusuf_yesilyurt.organizing_party.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import jakarta.validation.Valid;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-16T18:13:16.422362+02:00[Europe/Warsaw]")
@Validated
@Tag(name = "UserManagement", description = "the UserManagement API")
public interface UserManagementApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /auth/login : Logs in a user
     *
     * @param authRegisterPostRequest (optional)
     * @return User login successful (status code 200)
     *         or Invalid credentials (status code 401)
     */
    @Operation(operationId = "authLoginPost", summary = "Logs in a user", tags = { "User Management" }, responses = {
            @ApiResponse(responseCode = "200", description = "User login successful", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AuthLoginPost200Response.class))
            }),
            @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/auth/login", produces = { "application/json" }, consumes = {
            "application/json" })
    default ResponseEntity<AuthLoginPost200Response> _authLoginPost(
            @Parameter(name = "AuthRegisterPostRequest", description = "") @Valid @RequestBody(required = false) AuthRegisterPostRequest authRegisterPostRequest) {
        return authLoginPost(authRegisterPostRequest);
    }

    // Override this method
    default ResponseEntity<AuthLoginPost200Response> authLoginPost(AuthRegisterPostRequest authRegisterPostRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"token\" : \"token\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /auth/register : Registers a new user
     *
     * @param authRegisterPostRequest (optional)
     * @return User registration successful (status code 200)
     *         or Invalid request (status code 400)
     *         or Username already exists (status code 409)
     */
    @Operation(operationId = "authRegisterPost", summary = "Registers a new user", tags = {
            "User Management" }, responses = {
                    @ApiResponse(responseCode = "200", description = "User registration successful"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "409", description = "Username already exists")
            })
    @RequestMapping(method = RequestMethod.POST, value = "/auth/register", consumes = { "application/json" })
    default ResponseEntity<Void> _authRegisterPost(
            @Parameter(name = "AuthRegisterPostRequest", description = "") @Valid @RequestBody(required = false) AuthRegisterPostRequest authRegisterPostRequest) {
        return authRegisterPost(authRegisterPostRequest);
    }

    // Override this method
    default ResponseEntity<Void> authRegisterPost(AuthRegisterPostRequest authRegisterPostRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /users/{userId} : Deletes user account
     *
     * @param userId User ID (required)
     * @return User account deleted successfully (status code 200)
     *         or User not found (status code 404)
     */
    @Operation(operationId = "usersUserIdDelete", summary = "Deletes user account", tags = {
            "User Management" }, responses = {
                    @ApiResponse(responseCode = "200", description = "User account deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            })
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    default ResponseEntity<Void> _usersUserIdDelete(
            @Parameter(name = "userId", description = "User ID", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId) {
        return usersUserIdDelete(userId);
    }

    // Override this method
    default ResponseEntity<Void> usersUserIdDelete(Integer userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /users/{userId} : Gets user information
     *
     * @param userId User ID (required)
     * @return User information retrieved successfully (status code 200)
     *         or User not found (status code 404)
     */
    @Operation(operationId = "usersUserIdGet", summary = "Gets user information", tags = {
            "User Management" }, responses = {
                    @ApiResponse(responseCode = "200", description = "User information retrieved successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "User not found")
            })
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}", produces = { "application/json" })
    default ResponseEntity<User> _usersUserIdGet(
            @Parameter(name = "userId", description = "User ID", required = true, in = ParameterIn.PATH) @PathVariable("userId") Integer userId) {
        return usersUserIdGet(userId);
    }

    // Override this method
    default ResponseEntity<User> usersUserIdGet(Integer userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"id\" : 0, \"events\" : [ { \"imageUrl\" : \"https://openapi-generator.tech\", \"description\" : \"description\", \"id\" : 6, \"title\" : \"title\", \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"userId\" : 1, \"eventDate\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"imageUrl\" : \"https://openapi-generator.tech\", \"description\" : \"description\", \"id\" : 6, \"title\" : \"title\", \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"userId\" : 1, \"eventDate\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
