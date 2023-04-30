package mk.ukim.finki.emtlab2.service.impl;

import mk.ukim.finki.emtlab2.model.Country;
import mk.ukim.finki.emtlab2.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emtlab2.repository.CountryRepository;
import mk.ukim.finki.emtlab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(()->new InvalidCountryIdException(id));
    }

    @Override
    public Country findByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public Country add(Country c) {
        return this.countryRepository.save(c);
    }
}
