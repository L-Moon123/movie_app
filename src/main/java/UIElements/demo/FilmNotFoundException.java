package UIElements.demo;

public class FilmNotFoundException extends RuntimeException {
    FilmNotFoundException(int id) {
        super("Could not find film " + id);
    }
}
