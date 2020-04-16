package saracoglu.fatih.librarymanagementsystem.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import saracoglu.fatih.librarymanagementsystem.model.Author;
import saracoglu.fatih.librarymanagementsystem.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll(Sort.by("id"));
    }

    public Optional<Author> getAuthor(final Long id) {
        return authorRepository.findById(id);
    }

    public void addAuthor(final Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(final Long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(final Author author) {
        authorRepository.save(author);
    }

}
