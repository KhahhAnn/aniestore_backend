package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.Review;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.ReviewService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Review review) {
        Review response = this.reviewService.addNewReview(review);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Review review, @PathVariable UUID id) {
        Review response = this.reviewService.updateReview(review, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        ResponseEntity<?> response = this.reviewService.deleteReview(id);
        return response;
    }
}
