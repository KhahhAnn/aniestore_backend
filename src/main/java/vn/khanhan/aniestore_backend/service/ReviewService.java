package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Review;

import java.util.UUID;

@Service
public interface ReviewService {
    public Review addNewReview(Review review);

    public Review updateReview(Review review, UUID id);

    public ResponseEntity<?> deleteReview(UUID id);
}
