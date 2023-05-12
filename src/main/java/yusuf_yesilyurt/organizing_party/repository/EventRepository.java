package yusuf_yesilyurt.organizing_party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import yusuf_yesilyurt.organizing_party.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByUserId(Integer userId);
}
