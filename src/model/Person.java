package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Person {

    private static int count = 0;
    private final String sysId;
    private final String personId;
    private final String name;
    private final String email;
    private final Date birthDate;

    // A protected constructor can only be accessed only by the subclasses in other package or any class within the package of the protected class.
    protected Person(String personId, String name, String email, Date birthDate) {
        
        if (personId == null || personId.isBlank()) {
            throw new IllegalArgumentException("Personal ID cannot be null or blank.");
        }

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
        this.sysId = "000" + Integer.toString(count);
        this.personId = personId;
        this.name = name;
        this.email = email + "@mymail.generation.edu.sg";
        this.birthDate = birthDate;
    }

    protected Person(Person source) {
        this.sysId = source.sysId;
        this.personId = source.personId;
        this.name = source.name;
        this.email = source.email;
        this.birthDate = source.birthDate;
    }

    public String getSysId() {
        return sysId;
    }

    public String getName() {
        return name;
    }

    public String getPersonId() {
        return this.personId;
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
            " sysId='" + getSysId() + "'" +
            ", personId='" + getPersonId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            " }";
    }
    
}
