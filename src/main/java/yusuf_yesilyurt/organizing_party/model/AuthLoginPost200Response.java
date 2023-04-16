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

  public AuthLoginPost200Response token(String token) {
    this.token = token;
    return this;
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
