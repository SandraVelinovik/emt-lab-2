package mk.ukim.finki.emtlab2.model.exceptions;

public class InvalidCountryIdException extends RuntimeException{
    public InvalidCountryIdException(Long id){
        super(String.format("Country with id: %d was not found.",id));
    }
}
