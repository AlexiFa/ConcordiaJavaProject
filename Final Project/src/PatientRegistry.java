import java.util.ArrayList;
import java.util.List;

public class PatientRegistry {
    private List<Patient> patients;

    public PatientRegistry() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null;
    }

    public Patient findPatientBySSN(int ssn) {
        for (Patient patient : patients) {
            if (patient.getssnNumber() == ssn) {
                return patient;
            }
        }
        return null;
    }

    public int getLastPatientID() {
        return patients.get(patients.size() - 1).getPatientID();
    }

    public Patient getPatient(int i) {
        return patients.get(i);
    }

    public void printPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    public Patient findPatientByID(int id) {
        for (Patient patient : patients) {
            if (patient.getPatientID() == id) {
                return patient;
            }
        }
        return null;
    }
}
