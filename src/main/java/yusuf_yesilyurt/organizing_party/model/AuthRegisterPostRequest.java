package yusuf_yesilyurt.organizing_party.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * AuthRegisterPostRequest
 */

@JsonTypeName("_auth_register_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-16T18:13:16.422362+02:00[Europe/Warsaw]")
public class AuthRegisterPostRequest {

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public AuthRegisterPostRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User's username
   * 
   * @return username
   */
  @NotNull
  @Schema(name = "username", description = "User's username", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AuthRegisterPostRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User's password
   * 
   * @return password
   */
  @NotNull
  @Schema(name = "password", description = "User's password", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthRegisterPostRequest authRegisterPostRequest = (AuthRegisterPostRequest) o;
    return Objects.equals(this.username, authRegisterPostRequest.username) &&
        Objects.equals(this.password, authRegisterPostRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthRegisterPostRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
