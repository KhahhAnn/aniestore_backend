package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khanhan.aniestore_backend.entity.Discount;

import java.util.UUID;

@RepositoryRestResource(path = "discount")
@CrossOrigin("*")
public interface DiscountRepository extends JpaRepository<Discount, UUID> {
}
