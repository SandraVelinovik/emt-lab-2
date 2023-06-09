package mk.ukim.finki.emtlab2.repository;

import mk.ukim.finki.emtlab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
    Country findByName(String name);
}
