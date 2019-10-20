package net.sahet.springtech.service;

import net.sahet.springtech.domain.Book;
import net.sahet.springtech.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository repository;

    public String getBookById(long id) {
        Optional<Book> bookById = repository.findById(id);
        return bookById.isPresent()? bookById.get().getName() : "";
    }

    public List<Book> getAllBooks(String name) {
        return repository.findByName(name);
    }
}
