package vn.khanhan.aniestore_backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Users;

@Service
public interface UsersService extends UserDetailsService {
    public Users findUserByEmail(String email);
}
