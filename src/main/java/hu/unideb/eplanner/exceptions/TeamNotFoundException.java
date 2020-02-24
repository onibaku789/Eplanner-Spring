package hu.unideb.eplanner.exceptions;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(Long id) {
        super("Could not find team with id " + id);
    }

    public TeamNotFoundException(String name) {
        super("could not find team with name " + name);
    }
}
