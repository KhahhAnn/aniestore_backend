package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Roles;
import vn.khanhan.aniestore_backend.entity.Users;
import vn.khanhan.aniestore_backend.repository.RolesRepository;
import vn.khanhan.aniestore_backend.repository.UsersRepository;
import vn.khanhan.aniestore_backend.service.AccountService;
import vn.khanhan.aniestore_backend.service.EmailService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;
    private EmailService emailService;
    private RolesRepository rolesRepository;

    @Override
    public ResponseEntity<?> register(Users user) {
        if(this.usersRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email exist");
        }
        if(user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Password is not null");
        }
        String encryptPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        user.setActiveCode(createActiveCode());
        user.setActive(false);
        List<Roles> defaultRoles = this.rolesRepository.findByRoleName("USER_ROLE");
        user.setRolesList(defaultRoles);
        user.setCreateAt(new Date(System.currentTimeMillis()));
        user.setUpdateAt(new Date(System.currentTimeMillis()));
        Users newUser = this.usersRepository.saveAndFlush(user);
        sendMailActiveCode(user.getEmail(), user.getActiveCode());
        return ResponseEntity.ok("Register success!");
    }

    @Override
    public String createActiveCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void sendMailActiveCode(String email, String activeCode) {
        String subject = "Kích hoạt tài khoản của bạn tại Aniestore";
        String text = "Vui lòng sử dụng đoạn mã sau để kích hoạt tài khoản < " + email + ">:<html><body><br/><h1>"+ activeCode +"</h1></body></html>";
        text+= "<br/> Click vào link để kích hoạt tài khoản: ";
        String url = "http://localhost:8080/api/active/"+ email + "/" + activeCode;
        text+= ("<br/> <a href="+url+">"+ url +"</a>");
        this.emailService.sendEmail("khanhanbui2003@gmail.com", email, subject, text);
    }

    @Override
    public ResponseEntity<?> activeAccount(String email, String activeCode) {
        Users user = this.usersRepository.findByEmail(email);
        if(user == null) {
            return ResponseEntity.badRequest().body("Account not exist");
        }
        if(user.isActive()) {
            return ResponseEntity.badRequest().body("Account has been activated");
        }
        if(activeCode.equals(user.getActiveCode())) {
            user.setActive(true);
            user.setActiveCode("");
            user.setUpdateAt(new Date(System.currentTimeMillis()));
            this.usersRepository.save(user);
            return ResponseEntity.ok("Active success!");
        } else {
            return ResponseEntity.badRequest().body("Wrong activation code!");
        }
    }

    @Override
    public ResponseEntity<?> signIn(Users user) {
        Users existsUser = this.usersRepository.findByEmail(user.getEmail());
        if(existsUser == null || !passwordEncoder.matches(user.getPassword(), existsUser.getPassword())) {
            return ResponseEntity.badRequest().body("User account or password incorrect!");
        }
        if(!existsUser.isActive()) {
            return ResponseEntity.badRequest().body("Account has not been activated!");
        }
        return ResponseEntity.ok("Logged in successfully!");
    }
}
