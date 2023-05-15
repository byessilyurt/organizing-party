package yusuf_yesilyurt.organizing_party.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.EventsGetRequest;
import yusuf_yesilyurt.organizing_party.model.User;
import yusuf_yesilyurt.organizing_party.service.EventService;
import yusuf_yesilyurt.organizing_party.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EventPlanningController implements EventPlanningApi {

    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventPlanningController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> eventsEventIdDelete(Integer eventId) {
        Optional<Event> eventOptional = eventService.getEventById(eventId);
        if (eventOptional.isPresent()) {
            eventService.deleteEvent(eventId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Event> eventsEventIdGet(Integer eventId) {
        Optional<Event> eventOptional = eventService.getEventById(eventId);
        if (eventOptional.isPresent()) {
            return ResponseEntity.ok(eventOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> eventsEventIdPut(Integer eventId, Event event) {
        Optional<Event> eventOptional = eventService.getEventById(eventId);
        if (eventOptional.isPresent()) {
            event.setId(eventId);
            eventService.saveEvent(event);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Event>> eventsGet(Integer page, Integer limit) {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @Override
    public ResponseEntity<Void> eventsPost(EventsGetRequest eventsGetRequest) {
        Optional<User> userOptional = userService.getUserById(eventsGetRequest.getUserId());
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User user = userOptional.get();
        Event event = new Event()
                .title(eventsGetRequest.getTitle())
                .creationDate(eventsGetRequest.getCreationDate())
                .eventDate(eventsGetRequest.getEventDate())
                .description(eventsGetRequest.getDescription())
                .imageUrl(eventsGetRequest.getImageUrl())
                .setUser(user);
        eventService.saveEvent(event);
        userService.addEventToUser(user, event);

        return ResponseEntity.created(URI.create("/events/" + event.getId())).build();
    }

}
