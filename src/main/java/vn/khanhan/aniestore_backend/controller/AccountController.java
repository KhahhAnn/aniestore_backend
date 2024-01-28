package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Users;
import vn.khanhan.aniestore_backend.security.JwtResponse;
import vn.khanhan.aniestore_backend.security.LoginRequest;
import vn.khanhan.aniestore_backend.service.AccountService;
import vn.khanhan.aniestore_backend.service.JwtService;
import vn.khanhan.aniestore_backend.service.UsersService;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AccountController {
    private AccountService accountService;
    private AuthenticationManager authenticationManager;
    private UsersService usersService;
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody Users user) {
        ResponseEntity<?> response = this.accountService.register(user);
        return response;
    }
    @GetMapping("/active/{email}/{activeCode}")
    public ResponseEntity<?> active(@PathVariable String email, @PathVariable String activeCode) {
        ResponseEntity<?> response = this.accountService.activeAccount(email, activeCode);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> loginUser(@Validated @RequestBody LoginRequest loginRequest)  {
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            if(authentication.isAuthenticated()) {
                final String token = jwtService.generateToken(loginRequest.getEmail());
                String userImg = this.usersService.findUserByEmail(loginRequest.getEmail()).getImage();
                return ResponseEntity.ok(new JwtResponse(token, userImg));
            }
        }catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().body("User account or password incorrect!");
        }
        return ResponseEntity.badRequest().body("Authentication not successful");
    }
}
