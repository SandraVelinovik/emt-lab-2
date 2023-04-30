package mk.ukim.finki.emtlab2.service;

import mk.ukim.finki.emtlab2.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll() ;
    Country findById(Long id);
    Country findByName(String name);
    Country add(Country c);
}
