package saracoglu.fatih.librarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import saracoglu.fatih.librarymanagementsystem.model.Author;
import saracoglu.fatih.librarymanagementsystem.services.AuthorService;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(final AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/admin/authors")
    public String getAuthorsForAdmin(Model model) {
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "author";
    }

    @GetMapping("/admin/authors/author")
    @ResponseBody
    public Optional<Author> getAuthor(final Long id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/home/author")
    @ResponseBody
    public Optional<Author> getAuthorForUser(final Long id) {
        return authorService.getAuthor(id);
    }

    @PostMapping("/admin/authors/add")
    public RedirectView addAuthor(final Author author) {
        authorService.addAuthor(author);
        return new RedirectView("/admin/authors");
    }

    @RequestMapping(value="/admin/authors/edit", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateAuthor(final Author author) {
        authorService.updateAuthor(author);
        return "redirect:/admin/authors";
    }

    @RequestMapping(value="/admin/authors/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(final Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/admin/authors";
    }
}
