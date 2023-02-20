import java.util.ArrayList;
import java.util.List;

public class PatientRegistry {
    private List<Patient> patients; // list of patients stored in the registry

    public PatientRegistry() {
        patients = new ArrayList<>(); // initialize an empty list of patients
    }

    // add a patient to the registry
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // remove a patient from the registry
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // return a list of all patients in the registry
    public List<Patient> getPatients() {
        return patients;
    }

    // find a patient in the registry by their name
    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null; // return null if the patient is not found
    }

    // find a patient in the registry by their social security number
    public Patient findPatientBySSN(int ssn) {
        for (Patient patient : patients) {
            if (patient.getssnNumber() == ssn) {
                return patient;
            }
        }
        return null; // return null if the patient is not found
    }

    // get the ID of the last patient added to the registry
    public int getLastPatientID() {
        return patients.get(patients.size() - 1).getPatientID();
    }

    // get a patient from the registry by their index in the list
    public Patient getPatient(int i) {
        return patients.get(i);
    }

    // print all patients in the registry
    public void printPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    // find a patient in the registry by their ID
    public Patient findPatientByID(int id) {
        for (Patient patient : patients) {
            if (patient.getPatientID() == id) {
                return patient;
            }
        }
        return null; // return null if the patient is not found
    }
}
