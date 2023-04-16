package yusuf_yesilyurt.organizing_party.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * EventsGetRequest
 */

@JsonTypeName("_events_get_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-16T18:13:16.422362+02:00[Europe/Warsaw]")
public class EventsGetRequest {

  @JsonProperty("title")
  private String title;

  @JsonProperty("creationDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  @JsonProperty("eventDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime eventDate;

  @JsonProperty("description")
  private String description;

  @JsonProperty("imageUrl")
  private URI imageUrl;

  @JsonProperty("userId")
  private Integer userId;

  public EventsGetRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Event title
   * 
   * @return title
   */
  @NotNull
  @Schema(name = "title", description = "Event title", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public EventsGetRequest creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Event creation date and time
   * 
   * @return creationDate
   */
  @NotNull
  @Valid
  @Schema(name = "creationDate", description = "Event creation date and time", requiredMode = Schema.RequiredMode.REQUIRED)
  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public EventsGetRequest eventDate(OffsetDateTime eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * Event date and time
   * 
   * @return eventDate
   */
  @NotNull
  @Valid
  @Schema(name = "eventDate", description = "Event date and time", requiredMode = Schema.RequiredMode.REQUIRED)
  public OffsetDateTime getEventDate() {
    return eventDate;
  }

  public void setEventDate(OffsetDateTime eventDate) {
    this.eventDate = eventDate;
  }

  public EventsGetRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Event description
   * 
   * @return description
   */
  @NotNull
  @Schema(name = "description", description = "Event description", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EventsGetRequest imageUrl(URI imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * Image URL for the event
   * 
   * @return imageUrl
   */
  @NotNull
  @Valid
  @Schema(name = "imageUrl", description = "Image URL for the event", requiredMode = Schema.RequiredMode.REQUIRED)
  public URI getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(URI imageUrl) {
    this.imageUrl = imageUrl;
  }

  public EventsGetRequest userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User ID of the event creator
   * 
   * @return userId
   */
  @NotNull
  @Schema(name = "userId", description = "User ID of the event creator", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventsGetRequest eventsGetRequest = (EventsGetRequest) o;
    return Objects.equals(this.title, eventsGetRequest.title) &&
        Objects.equals(this.creationDate, eventsGetRequest.creationDate) &&
        Objects.equals(this.eventDate, eventsGetRequest.eventDate) &&
        Objects.equals(this.description, eventsGetRequest.description) &&
        Objects.equals(this.imageUrl, eventsGetRequest.imageUrl) &&
        Objects.equals(this.userId, eventsGetRequest.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, creationDate, eventDate, description, imageUrl, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventsGetRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
