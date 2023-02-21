import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {

    // The name of the person
    protected String name;

    // The date of birth of the person
    protected Date dateOfBirth = new Date();

    // A date formatter to format the dateOfBirth field
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    // Constructor that takes the name and date of birth of the person as arguments
    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // Getter method to retrieve the name of the person
    public String getName() {
        return this.name;
    }

    // Getter method to retrieve the date of birth of the person
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    // Override the default toString() method to return the name and date of birth
    // of the person
    @Override
    public String toString() {
        return this.name + ", born " + this.dateOfBirth;
    }
}
