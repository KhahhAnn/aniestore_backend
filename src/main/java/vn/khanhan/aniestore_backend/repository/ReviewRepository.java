package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanhan.aniestore_backend.entity.Review;

import java.util.UUID;

@RepositoryRestResource(path = "review")
public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
