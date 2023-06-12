package yusuf_yesilyurt.organizing_party.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.User;
import yusuf_yesilyurt.organizing_party.service.EventService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class StatisticsAspect {

    private final ConcurrentHashMap<String, AtomicInteger> callCounts = new ConcurrentHashMap<>();
    private Event event;
    private User userWithMostEvents;
    private Event oldestEvent;
    private Event secondOldestEvent;

    @Autowired
    private EventService eventService;

    private AtomicInteger maxEventCount = new AtomicInteger();

    @Around("execution(* yusuf_yesilyurt.organizing_party.service..*.*(..))")
    public Object trackCallCount(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        callCounts.computeIfAbsent(methodName, k -> new AtomicInteger()).incrementAndGet();
        return pjp.proceed();
    }

    @AfterReturning(pointcut = "execution(* yusuf_yesilyurt.organizing_party.service.EventService.saveEvent(..))", returning = "result")
    public void trackOldestEventAfterSave(JoinPoint jp, Object result) {
        if (result instanceof Event) {
            Event event = (Event) result;
            if (oldestEvent == null || event.getEventDate().isBefore(oldestEvent.getEventDate())) {
                secondOldestEvent = oldestEvent;
                oldestEvent = event;
            } else if (event.equals(oldestEvent) && secondOldestEvent != null
                    && !event.getEventDate().equals(oldestEvent.getEventDate())) {
                oldestEvent = secondOldestEvent;
            }
        }
    }

    @Before("execution(* yusuf_yesilyurt.organizing_party.service.EventService.deleteEvent(..)) && args(id)")
    public void trackOldestEventBeforeDeletion(JoinPoint jp, Integer id) {
        Optional<Event> eventOptional = eventService.getEventById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            if (event.equals(oldestEvent)) {
                List<Event> events = eventService.getAllEventsSortedByDate();
                if (events.size() > 1) {
                    oldestEvent = events.get(1); // Getting the new oldest event
                } else {
                    oldestEvent = null; // There are no events left, or only one is left which is about to be deleted
                }
            }
        }
    }

    @AfterReturning(pointcut = "execution(* yusuf_yesilyurt.organizing_party.service.EventService.saveEvent(..))", returning = "result")
    public void trackUserWithMostEventsAfterCreation(JoinPoint jp, Object result) {
        if (result instanceof Event) {
            Event event = (Event) result;
            User user = event.getUser();
            if (user.getEvents().size() > maxEventCount.get()) {
                maxEventCount.set(user.getEvents().size());
                userWithMostEvents = user;
            }
        }
    }

    public ConcurrentHashMap<String, AtomicInteger> getCallCounts() {
        return callCounts;
    }

    public User getUserWithMostEvents() {
        return userWithMostEvents;
    }

    public Event getOldestEvent() {
        return oldestEvent;
    }
}
