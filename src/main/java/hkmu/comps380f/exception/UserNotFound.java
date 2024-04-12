package hkmu.comps380f.exception;

public class UserNotFound extends Exception{
    public UserNotFound(long id) {
        super(id + " does not exist.");
    }
}
