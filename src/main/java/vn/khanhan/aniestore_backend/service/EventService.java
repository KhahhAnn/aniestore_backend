package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Event;

import java.util.UUID;

@Service
public interface EventService {
    public Event addNewEvent(Event event);

    public Event updateEvent(Event event, UUID id);

    public ResponseEntity<?> deleteEvent(UUID id);
}
