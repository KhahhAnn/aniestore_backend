package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Review;
import vn.khanhan.aniestore_backend.repository.ReviewRepository;
import vn.khanhan.aniestore_backend.service.ReviewService;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    @Override
    public Review addNewReview(Review review) {
        Review newReview = new Review();
        newReview.setContentRated(review.getContentRated());
        newReview.setStar(review.getStar());
        newReview.setProducts(review.getProducts());
        newReview.setUser(review.getUser());
        newReview.setCreateAt(new Date(System.currentTimeMillis()));
        newReview.setUpdateAt(new Date(System.currentTimeMillis()));
        this.reviewRepository.saveAndFlush(newReview);
        return newReview;
    }

    @Override
    public Review updateReview(Review review, UUID id) {
        Review updateReview = this.reviewRepository.getReferenceById(id);
        if(updateReview == null) {
            return null;
        }
        updateReview.setContentRated(review.getContentRated() != null ? review.getContentRated() : updateReview.getContentRated());
        updateReview.setStar(review.getStar() < 0 ? review.getStar() : updateReview.getStar());
        updateReview.setProducts(review.getProducts() != null ? review.getProducts() : updateReview.getProducts());
        updateReview.setUser(review.getUser() != null ? review.getUser() : updateReview.getUser());
        updateReview.setUpdateAt(new Date(System.currentTimeMillis()));
        this.reviewRepository.saveAndFlush(updateReview);
        return updateReview;
    }

    @Override
    public ResponseEntity<?> deleteReview(UUID id) {
        if(!this.reviewRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.reviewRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
