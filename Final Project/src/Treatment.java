import java.util.Date;

public class Treatment {
    private Patient patient;
    private Doctor doctor;
    private String description;
    private Date date;

    // Constructor
    public Treatment(Patient patient, Doctor doctor, String description, Date date) {
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
        this.date = date;
    }

    // Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
