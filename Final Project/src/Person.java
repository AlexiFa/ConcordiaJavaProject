import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Person {
    protected String name;

    protected Date dateOfBirth = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public String toString() {
        return this.name + ", born " + this.dateOfBirth;
    }
}
