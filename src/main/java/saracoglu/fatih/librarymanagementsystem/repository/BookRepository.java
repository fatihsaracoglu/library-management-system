package saracoglu.fatih.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saracoglu.fatih.librarymanagementsystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
