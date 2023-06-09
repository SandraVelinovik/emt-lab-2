package mk.ukim.finki.emtlab2.service;

import mk.ukim.finki.emtlab2.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll() ;
    Author findById(Long id);
    Author findByName(String name);
    Author add(Author a);
}
