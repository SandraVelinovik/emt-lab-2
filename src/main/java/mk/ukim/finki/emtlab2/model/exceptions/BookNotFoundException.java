package mk.ukim.finki.emtlab2.model.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String name) {
        super(String.format("The book %s could not be found.", name));
    }
}
