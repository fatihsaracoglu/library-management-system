package saracoglu.fatih.librarymanagementsystem.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import saracoglu.fatih.librarymanagementsystem.model.Book;
import saracoglu.fatih.librarymanagementsystem.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll(Sort.by("id"));
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(final Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(final Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(final Book book) {
        return bookRepository.save(book);
    }

}
