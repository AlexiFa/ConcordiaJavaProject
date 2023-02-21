import java.util.Date;

public class Appointment{
    Date date = new Date();
    private int price;
    Doctor doctor;

    Patient patient;
    private int duration;
    private final int id;

    public Appointment(int id, Date date, Doctor doctor, Patient patient, int price, int duration) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.price = price;
        this.duration = duration;
        this.id = id;
    }


    public Date getDate() {
        return this.date;
    }

    public String getDoctor() {
        return this.doctor.getName();
    }

    public String getPatient() {
        return this.patient.getName();
    }

    public int getPrice() {
        return this.price;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Appointment{" +
            " date='" + getDate() + "'" +
            ", doctor='" + getDoctor() + "'" +
            ", patient='" + getPatient() + "'" +
            ", price='" + getPrice() + "'" +
            ", duration='" + getDuration() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }
}
