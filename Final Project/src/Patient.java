import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient extends Person {
    private final int ID;
    private Treatment treatment;
    private String address;
    private int phoneNumber;
    private String insuranceCompany;
    private String Employer;
    private int ssnNumber;
    private ArrayList<Treatment> MedicalHistory;




    public Patient(String name, Date dateOfBirth, int ID, ArrayList<Treatment> MedicalHistory, String address, int phoneNumber, String insuranceCompany,  String employer, int ssnNumber) {
        super(name, dateOfBirth);
        this.ID = ID;
        this.MedicalHistory = MedicalHistory;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.insuranceCompany = insuranceCompany;
        this.Employer = employer;
        this.ssnNumber = ssnNumber;
    }

    public int getPatientID() {
        return this.ID;
    }

    public List<Treatment> getMedicalHistory() {
        return this.MedicalHistory;
    }
    public void addMedicalHistory(Treatment treatment) {
        this.MedicalHistory.add(treatment);
    }
    public void setMedicalHistory(ArrayList<Treatment> medicalHistory) {
        this.MedicalHistory = medicalHistory;
    }
    public void removeMedicalHistory(Treatment treatment) {
        this.MedicalHistory.remove(treatment);
    }
    public void setssnNumber(int ssnNumber) {
        this.ssnNumber = ssnNumber;
    }
    public Treatment getTreatment() {
        return this.treatment;
    }

    public String getAddress() {
        return this.address;
    }

    public String getInsuranceCompany() {
        return this.insuranceCompany;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }


    public String getEmployer() {
        return this.Employer;
    }

    public int getssnNumber() {
        return this.ssnNumber;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }


    public void setEmployer(String employer) {
        this.Employer = employer;
    }

    public void setSsnNumber(int ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + ID +
                ", Name='" + getName() + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", Employer='" + Employer + '\'' +
                ", ssnNumber=" + ssnNumber +
                '}';
    }


    public int getPatientId() {
        return ID;
    }

    /**
     * to make a backup of the medical history in a file.out
     */
    public void updateMedicalHistory(){
        try{
            PrintWriter outFile = new PrintWriter("MedicalHistory.out");
            System.out.println("voila");
            outFile.close();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}