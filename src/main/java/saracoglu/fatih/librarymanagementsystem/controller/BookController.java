package saracoglu.fatih.librarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import saracoglu.fatih.librarymanagementsystem.model.Author;
import saracoglu.fatih.librarymanagementsystem.model.Book;
import saracoglu.fatih.librarymanagementsystem.services.AuthorService;
import saracoglu.fatih.librarymanagementsystem.services.BookService;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/home")
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooks();
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        return "index";
    }

    @GetMapping("/admin/books")
    public String getBooksForAdmin(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "book";
    }

    @GetMapping("/admin/books/book")
    @ResponseBody
    public Optional<Book> getBook(final Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/home/book")
    @ResponseBody
    public Optional<Book> getBookForUser(final Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/admin/books/add")
    public RedirectView addBook(final Book book) {
        bookService.addBook(book);
        return new RedirectView("/admin/books");
    }

    @RequestMapping(value="/admin/books/edit", method = {RequestMethod.POST, RequestMethod.GET})
    public RedirectView updateBook(final Book book) {
        bookService.updateBook(book);
        return new RedirectView("/admin/books");
    }

    @RequestMapping(value="/admin/books/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public RedirectView delete(final Long id) {
        bookService.deleteBook(id);
        return new RedirectView("/admin/books");
    }
}
