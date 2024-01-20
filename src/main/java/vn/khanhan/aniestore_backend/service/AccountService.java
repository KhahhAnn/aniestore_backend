package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Users;

@Service
public interface AccountService {
    public ResponseEntity<?> register(Users user);

    public String createActiveCode();

    public void sendMailActiveCode(String email, String activeCode);

    public ResponseEntity<?> activeAccount(String email, String activeCode);

    public ResponseEntity<?> signIn(Users user);
}
