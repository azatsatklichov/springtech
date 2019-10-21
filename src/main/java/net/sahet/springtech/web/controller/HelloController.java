package net.sahet.springtech.web.controller;

import net.sahet.springtech.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book")
    public ModelAndView hiBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        modelAndView.addObject("books", "Hi Book. You like: " + bookService.getBookById(1));
        return modelAndView;
    }

    ;

    @GetMapping(value = "/getAllBooks")
    public String getAllBooks() {
        return "Hi Book. All Java books are here: " + bookService.getAllBooks("Java");
    }

    ;

}
