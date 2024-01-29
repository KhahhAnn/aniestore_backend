package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Review;
import vn.khanhan.aniestore_backend.entity.Roles;
import vn.khanhan.aniestore_backend.repository.RolesRepository;
import vn.khanhan.aniestore_backend.service.RolesService;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RolesServiceImpl implements RolesService {
    private RolesRepository rolesRepository;
    @Override
    public Roles addNewRole(Roles role) {
        Roles newRole = new Roles();
        newRole.setRoleName(role.getRoleName());
        newRole.setUserList(role.getUserList());
        newRole.setCreateAt(new Date(System.currentTimeMillis()));
        newRole.setUpdateAt(new Date(System.currentTimeMillis()));
        this.rolesRepository.saveAndFlush(newRole);
        return newRole;
    }

    @Override
    public Roles updateRole(Roles role, UUID id) {
        Roles updateRole = this.rolesRepository.getReferenceById(id);
        if(updateRole == null) {
            return null;
        }
        updateRole.setRoleName(role.getRoleName() != null ? role.getRoleName() : updateRole.getRoleName());
        updateRole.setUserList(role.getUserList() != null ? role.getUserList() : updateRole.getUserList());
        updateRole.setUpdateAt(new Date(System.currentTimeMillis()));
        this.rolesRepository.saveAndFlush(updateRole);
        return updateRole;
    }

    @Override
    public ResponseEntity<?> deleteRole(UUID id) {
        if(!this.rolesRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.rolesRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
