package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import vn.khanhan.aniestore_backend.entity.Roles;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "role")
@CrossOrigin("*")
public interface RolesRepository extends JpaRepository<Roles, UUID> {
    public List<Roles> findByRoleName(String roleName);
}
