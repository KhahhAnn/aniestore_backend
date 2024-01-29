package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Review;
import vn.khanhan.aniestore_backend.entity.Roles;

import java.util.UUID;

@Service
public interface RolesService {
    public Roles addNewRole(Roles role);

    public Roles updateRole(Roles role, UUID id);

    public ResponseEntity<?> deleteRole(UUID id);
}
