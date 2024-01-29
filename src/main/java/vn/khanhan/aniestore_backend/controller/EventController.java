package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Discount;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.service.DiscountService;
import vn.khanhan.aniestore_backend.service.EventService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        Event response = this.eventService.addNewEvent(event);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Event event, @PathVariable UUID id) {
        Event response = this.eventService.updateEvent(event, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable UUID id) {
        ResponseEntity<?> response = this.eventService.deleteEvent(id);
        return response;
    }
}
