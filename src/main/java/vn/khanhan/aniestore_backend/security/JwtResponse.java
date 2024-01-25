package vn.khanhan.aniestore_backend.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import vn.khanhan.aniestore_backend.entity.Users;

@Data
@AllArgsConstructor
public class JwtResponse {
    private final String token;
    private String img;
}
