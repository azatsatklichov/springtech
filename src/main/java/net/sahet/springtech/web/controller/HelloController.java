package net.sahet.springtech.web.controller;

import net.sahet.springtech.service.BookService;
import net.sahet.springtech.service.KitapService;

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
    
    @Autowired
    private KitapService kitapService;

    @GetMapping(value = "/book")
    public ModelAndView hiBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        modelAndView.addObject("books", "Hi Book!!! Book category: " + bookService.getBookById(1));
        return modelAndView;
    }

    @GetMapping(value = "/getAllBooks")
    public String getAllBooks() {
        return "Hi Book. All Java books are here: " + bookService.getAllBooks("Java");
    }
    
    @GetMapping(value = "/kitap")
    public ModelAndView hiKitap() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("kitap");
        modelAndView.addObject("kitaps", "Hi Kitap!!! Kitap category: " + kitapService.getKitapById(1));
        return modelAndView;
    }

    @GetMapping(value = "/getAllKitaps")
    public String getAllKitaps() {
        return "Hi Book. All Java kitaplar: " + kitapService.getAllKitaps("Java");
    }
}
