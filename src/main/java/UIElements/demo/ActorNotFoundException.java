package UIElements.demo;

public class ActorNotFoundException extends RuntimeException {
    ActorNotFoundException(int id) {
        super("Could not find actor " + id);
    }
}
