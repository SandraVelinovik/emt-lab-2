package mk.ukim.finki.emtlab2.service;

import mk.ukim.finki.emtlab2.model.Author;
import mk.ukim.finki.emtlab2.model.Book;
import mk.ukim.finki.emtlab2.model.dto.BookDto;
import mk.ukim.finki.emtlab2.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);
    Book add(String name, Category category,Author author, int availableCopies);
    Book delete(Long id);
    Book update(Long id,String name, Category category, Author author, int availableCopies);
    Optional<Book> markAsTaken(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> update(Long id,BookDto bookDto);

}
