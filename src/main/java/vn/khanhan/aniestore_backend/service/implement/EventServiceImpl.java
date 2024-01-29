package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Category;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.repository.EventRepository;
import vn.khanhan.aniestore_backend.service.EventService;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Override
    public Event addNewEvent(Event event) {
        Event newEvent = new Event();
        newEvent.setEventName(event.getEventName());
        newEvent.setCreateAt(new Date(System.currentTimeMillis()));
        newEvent.setUpdateAt(new Date(System.currentTimeMillis()));
        newEvent.setImage(event.getImage());
        newEvent.setLink(event.getLink());
        this.eventRepository.saveAndFlush(newEvent);
        return newEvent;
    }

    @Override
    public Event updateEvent(Event event, UUID id) {
        Event updateEvent = this.eventRepository.getReferenceById(id);
        if (updateEvent == null) {
            return null;
        }
        updateEvent.setEventName(event.getEventName() != null ? event.getEventName() : updateEvent.getEventName());
        updateEvent.setLink(event.getLink() != null ? event.getLink() : updateEvent.getLink());
        updateEvent.setImage(event.getImage() != null ? event.getImage() : updateEvent.getImage());
        updateEvent.setUpdateAt(new Date(System.currentTimeMillis()));
        this.eventRepository.saveAndFlush(updateEvent);
        return updateEvent;
    }

    @Override
    public ResponseEntity<?> deleteEvent(UUID id) {
        if(!this.eventRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.eventRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
