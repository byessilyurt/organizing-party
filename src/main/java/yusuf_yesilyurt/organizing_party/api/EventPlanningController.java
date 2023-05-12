package yusuf_yesilyurt.organizing_party.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.EventsGetRequest;
import yusuf_yesilyurt.organizing_party.model.User;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class EventPlanningController implements EventPlanningApi {

    private final Map<Integer, Event> eventMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public ResponseEntity<Void> eventsEventIdDelete(Integer eventId) {
        if (eventMap.remove(eventId) != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Event> eventsEventIdGet(Integer eventId) {
        Event event = eventMap.get(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> eventsEventIdPut(Integer eventId, Event event) {
        if (eventMap.containsKey(eventId)) {
            event.setId(eventId);
            eventMap.put(eventId, event);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Event>> eventsGet(Integer page, Integer limit) {
        int pageNumber = page != null ? page : 1;
        int pageSize = limit != null ? limit : 10;

        int skip = (pageNumber - 1) * pageSize;

        List<Event> events = eventMap.values().stream()
                .skip(skip)
                .limit(pageSize)
                .collect(Collectors.toList());

        return ResponseEntity.ok(events);
    }

    @Override
    public ResponseEntity<Void> eventsPost(EventsGetRequest eventsGetRequest) {
        Event event = new Event()
                .id(idCounter.getAndIncrement())
                .title(eventsGetRequest.getTitle())
                .creationDate(eventsGetRequest.getCreationDate())
                .eventDate(eventsGetRequest.getEventDate())
                .description(eventsGetRequest.getDescription())
                .imageUrl(eventsGetRequest.getImageUrl())
                .userId(eventsGetRequest.getUserId());

        eventMap.put(event.getId(), event);

        // Fetch the user who created the event.
        User user = UserManagementController.userMap.get(event.getUserId());

        // If the user does not exist, return a 404 error.
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // If the user's events list is null, initialize it.
        if (user.getEvents() == null) {
            user.setEvents(new ArrayList<>());
        }

        // Add the new event to the user's events list.
        user.getEvents().add(event);

        // Put the updated user back into the map.
        UserManagementController.userMap.put(user.getId(), user);

        return ResponseEntity.created(URI.create("/events/" + event.getId())).build();
    }

}