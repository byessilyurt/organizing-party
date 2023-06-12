package yusuf_yesilyurt.organizing_party.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yusuf_yesilyurt.organizing_party.aspect.StatisticsAspect;
import yusuf_yesilyurt.organizing_party.model.Event;
import yusuf_yesilyurt.organizing_party.model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsAspect statisticsAspect;

    @GetMapping("/callCounts")
    public ConcurrentHashMap<String, AtomicInteger> getCallCounts() {
        return statisticsAspect.getCallCounts();
    }

    @GetMapping("/oldestEvent")
    public Event getOldestEvent() {
        return statisticsAspect.getOldestEvent();
    }

    @GetMapping("/userWithMostEvents")
    public User getUserWithMostEvents() {
        return statisticsAspect.getUserWithMostEvents();
    }
}
