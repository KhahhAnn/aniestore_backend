package vn.khanhan.aniestore_backend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Roles;
import vn.khanhan.aniestore_backend.entity.Users;
import vn.khanhan.aniestore_backend.repository.UsersRepository;
import vn.khanhan.aniestore_backend.service.UsersService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findUserByEmail(String email) {
        return this.usersRepository.findByEmail(email);
    }
    @Override
    public boolean isAdmin(String email) {
        List<Roles> rolesList = this.usersRepository.findByEmail(email).getRolesList();
        return rolesList.stream().anyMatch(role -> role.getRoleName().equals("ADMIN_ROLE"));

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = this.findUserByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new User(user.getEmail(), user.getPassword(), roleToAuthorities(user.getRolesList()));
    }

    private Collection<? extends GrantedAuthority> roleToAuthorities(Collection<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
