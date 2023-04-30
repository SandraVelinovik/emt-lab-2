package mk.ukim.finki.emtlab2.repository;

import mk.ukim.finki.emtlab2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);
}
