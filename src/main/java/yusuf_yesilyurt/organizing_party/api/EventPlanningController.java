package yusuf_yesilyurt.organizing_party.api;

import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.EventsGetRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class EventPlanningController implements EventPlanningApi {

    @Override
    public ResponseEntity<Void> eventsEventIdDelete(Integer eventId) {
        // TODO: Implement delete event logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Event> eventsEventIdGet(Integer eventId) {
        // TODO: Implement get event by id logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> eventsEventIdPut(Integer eventId, Event event) {
        // TODO: Implement update event logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Event>> eventsGet(Integer page, Integer limit) {
        // TODO: Implement get events with pagination logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> eventsPost(EventsGetRequest eventsGetRequest) {
        // TODO: Implement create event logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
