package mk.ukim.finki.emtlab2.service.impl;

import mk.ukim.finki.emtlab2.model.Author;
import mk.ukim.finki.emtlab2.model.Book;
import mk.ukim.finki.emtlab2.model.Country;
import mk.ukim.finki.emtlab2.model.dto.BookDto;
import mk.ukim.finki.emtlab2.model.enumerations.Category;
import mk.ukim.finki.emtlab2.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab2.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emtlab2.model.exceptions.InvalidBookIdException;
import mk.ukim.finki.emtlab2.repository.AuthorRepository;
import mk.ukim.finki.emtlab2.repository.BookRepository;
import mk.ukim.finki.emtlab2.repository.CountryRepository;
import mk.ukim.finki.emtlab2.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new InvalidBookIdException(id));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> findByName(String name) {
        Book book =  this.bookRepository.findByName(name).orElseThrow(()->new BookNotFoundException(name));
        return Optional.of(book);
    }

    @Override
    public Book add(String name, Category category, Author author, int availableCopies) {
        Book book = new Book();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book=this.findById(id).orElseThrow(()->new InvalidBookIdException(id));
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public Book update(Long id,String name, Category category,Author author,int availableCopies) {
        Book book=this.findById(id).orElseThrow(()->new InvalidBookIdException(id));
        book.setName(name);
        book.setCategory(category);;
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book=this.findById(id).orElseThrow(()->new InvalidBookIdException(id));
        int copies=book.getAvailableCopies()-1;
        book.setAvailableCopies(copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> save(BookDto bookDto) {
        this.countryRepository.save(bookDto.getAuthor().getCountry());
        this.authorRepository.save(bookDto.getAuthor());
        Book book = new Book(bookDto.getName(),
                bookDto.getCategory(),
                bookDto.getAuthor(),
                bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> update(Long id, BookDto bookDto) {
        this.countryRepository.save(bookDto.getAuthor().getCountry());
        this.authorRepository.save(bookDto.getAuthor());
        Book book=this.findById(id).orElseThrow(()->new InvalidBookIdException(id));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
