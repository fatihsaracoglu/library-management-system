package saracoglu.fatih.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saracoglu.fatih.librarymanagementsystem.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
