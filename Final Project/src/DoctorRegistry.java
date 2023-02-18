import java.util.ArrayList;
import java.util.List;

public class DoctorRegistry {
    private List<Doctor> doctors;

    public DoctorRegistry() {
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Doctor> findDoctorsByName(String name) {
        List<Doctor> matchingDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                matchingDoctors.add(doctor);
            }
        }
        return matchingDoctors;
    }

    public List<Doctor> findDoctorsBySpecialty(String specialty) {
        List<Doctor> matchingDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
                matchingDoctors.add(doctor);
            }
        }
        return matchingDoctors;
    }


    public Doctor getDoctor(int i) {
        return doctors.get(i);
    }

    public Doctor findDoctorByID(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorID() == id) {
                return doctor;
            }
        }
        return null;
    }
}
