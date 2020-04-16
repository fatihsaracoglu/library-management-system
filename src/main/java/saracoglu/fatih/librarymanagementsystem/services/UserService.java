package saracoglu.fatih.librarymanagementsystem.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import saracoglu.fatih.librarymanagementsystem.dto.UserDto;
import saracoglu.fatih.librarymanagementsystem.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserDto user);
}
