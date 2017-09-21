package model;

/**
 * Created by Ali on 21.09.2017.
 */
public class User {
    String emailAddress;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User(String emailAddress, String name) {
        this.emailAddress = emailAddress;
        this.name = name;
    }
}
