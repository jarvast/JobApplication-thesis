package jarvast.app.jobs.service;

public class UserNotFoundException extends Exception {
    UserNotFoundException(String msg) {
        super(msg);
    }
}
