package yusuf_yesilyurt.organizing_party.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * AuthLoginPost200Response
 */

@JsonTypeName("_auth_login_post_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-16T18:13:16.422362+02:00[Europe/Warsaw]")
public class AuthLoginPost200Response {
  @JsonProperty("token")
  private String token;

  @JsonProperty("userId")
  private Integer userId;

  @JsonProperty("username")
  private String username;

  public AuthLoginPost200Response token(String token) {
    this.token = token;
    return this;
  }

  public AuthLoginPost200Response userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  @Schema(name = "userId", description = "User ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AuthLoginPost200Response username(String username) {
    this.username = username;
    return this;
  }

  @Schema(name = "username", description = "Username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Access token for the user
   * 
   * @return token
   */

  @Schema(name = "token", description = "Access token for the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthLoginPost200Response authLoginPost200Response = (AuthLoginPost200Response) o;
    return Objects.equals(this.token, authLoginPost200Response.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthLoginPost200Response {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
