import java.util.Date;
public class Doctor extends Person {

    private String lastName;
    private String address;
    private int phoneNumber;
    private int seniority;
    private Date dateOfEmployment;
    private String speciality;
    private final int doctorId;

    public Doctor(int doctorId, String name, Date dateOfBirth, String lastName, String address, int phoneNumber, int seniority, Date dateOfEmployment, String speciality) {
        super(name, dateOfBirth);
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.seniority = seniority;
        this.dateOfEmployment = dateOfEmployment;
        this.speciality = speciality;
        this.doctorId = doctorId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getSeniority() {
        return this.seniority;
    }

    public Date getDateOfEmployment() {
        return this.dateOfEmployment;
    }

    public int getDoctorId() {
        return this.doctorId;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", doctorId=" + doctorId +
                "lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", seniority=" + seniority +
                ", dateOfEmployment=" + dateOfEmployment +
                ", speciality='" + speciality + '\'' +
                '}';
        }
    public String getSpecialty() {
        return this.speciality;
    }

    public int getDoctorID() {
        return this.doctorId;
    }
}