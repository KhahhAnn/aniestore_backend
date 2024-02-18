package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.Roles;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.RolesService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RolesController {
    private RolesService rolesService;

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody Roles roles) {
        Roles response = this.rolesService.addNewRole(roles);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@RequestBody Roles roles, @PathVariable UUID id) {
        Roles response = this.rolesService.updateRole(roles, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable UUID id) {
        ResponseEntity<?> response = this.rolesService.deleteRole(id);
        return response;
    }
}
