package saracoglu.fatih.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saracoglu.fatih.librarymanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
}
