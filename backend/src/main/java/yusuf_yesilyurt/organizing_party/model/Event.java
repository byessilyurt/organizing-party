package yusuf_yesilyurt.organizing_party.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Event
 */
@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private User user;

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

  public Event id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Event ID
   * 
   * @return id
   */
  @NotNull
  @Schema(name = "id", description = "Event ID", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Event title(String title) {
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

  public Event creationDate(OffsetDateTime creationDate) {
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

  public Event eventDate(OffsetDateTime eventDate) {
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

  public Event description(String description) {
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

  public Event imageUrl(URI imageUrl) {
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

  @JsonProperty("userId")
  public Integer getUserId() {
    return this.user != null ? this.user.getId() : null;
  }

  @JsonIgnore
  public User getUser() {
    return user;
  }

  public Event setUser(User user) {
    this.user = user;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.id, event.id) &&
        Objects.equals(this.title, event.title) &&
        Objects.equals(this.creationDate, event.creationDate) &&
        Objects.equals(this.eventDate, event.eventDate) &&
        Objects.equals(this.description, event.description) &&
        Objects.equals(this.imageUrl, event.imageUrl) &&
        Objects.equals(this.user, event.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, creationDate, eventDate, description, imageUrl, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
