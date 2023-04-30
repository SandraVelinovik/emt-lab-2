package mk.ukim.finki.emtlab2.model.dto;

import lombok.Data;
import mk.ukim.finki.emtlab2.model.Author;
import mk.ukim.finki.emtlab2.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private Author author;

    private int availableCopies;

    public BookDto() {

    }

    public BookDto(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
