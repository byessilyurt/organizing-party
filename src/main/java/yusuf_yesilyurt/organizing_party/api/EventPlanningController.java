package yusuf_yesilyurt.organizing_party.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.EventsGetRequest;

import java.net.URI;
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

        return ResponseEntity.created(URI.create("/events/" + event.getId())).build();
    }
}