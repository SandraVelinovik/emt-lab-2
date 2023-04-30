package mk.ukim.finki.emtlab2.model.exceptions;

public class InvalidAuthorIdException extends RuntimeException{
    public InvalidAuthorIdException(Long id){
        super(String.format("Author with id: %d was not found.",id));
    }
}
