package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khanhan.aniestore_backend.entity.Users;

import java.util.UUID;

@RepositoryRestResource(path = "user")
@CrossOrigin("*")
public interface UsersRepository extends JpaRepository<Users, UUID> {
    public Users findByEmail(String email);

    public Users findByEmailAndPassword(String email, String password);

    public boolean existsByEmail(String email);

}
