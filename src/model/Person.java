package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Person {

    private static int count = 0;
    private final String id;
    private final String name;
    private final String email;
    private final Date birthDate;

    // A protected constructor can only be accessed only by the subclasses in other package or any class within the package of the protected class.
    protected Person(String name, String email, Date birthDate) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }

        count++;
        this.id = "000" + Integer.toString(count);
        this.name = name;
        this.email = email + "@mymail.generation.edu.sg";
        this.birthDate = birthDate;
    }

    protected Person(Person source) {
        this.id = source.id;
        this.name = source.name;
        this.email = source.email;
        this.birthDate = source.birthDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(birthDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            " }";
    }
    
}
