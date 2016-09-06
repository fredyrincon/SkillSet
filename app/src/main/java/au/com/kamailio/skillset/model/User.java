package au.com.kamailio.skillset.model;

import javax.inject.Inject;

/**
 * Created by FRincon on 6/09/16.
 */
public class User {

    private String firstName;
    private String lastName;

    @Inject
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
