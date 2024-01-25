package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khanhan.aniestore_backend.entity.Order;

import java.util.UUID;

@RepositoryRestResource(path = "order")
@CrossOrigin("*")
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
