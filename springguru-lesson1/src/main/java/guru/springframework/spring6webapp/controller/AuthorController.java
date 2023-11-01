package guru.springframework.spring6webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.service.AuthorService;


@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }

}
