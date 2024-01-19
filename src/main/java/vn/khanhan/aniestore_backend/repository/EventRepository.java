package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanhan.aniestore_backend.entity.Event;

import java.util.UUID;

@RepositoryRestResource(path = "event")
public interface EventRepository extends JpaRepository<Event, UUID> {
}
