import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentScheduler {
    private static List<Appointment> appointments;

    public AppointmentScheduler() {
        appointments = new ArrayList<>();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void scheduleAppointment(Patient patient, Doctor doctor, Date date, int price, int duration, int id) {
        Appointment appointment = new Appointment(id, date, doctor, patient, price, duration);
        appointments.add(appointment);
    }

    public  void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }

    public List<Appointment> getAppointmentsByPatient(Patient patient) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient)) {
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }

    public Appointment findAppointment(Patient patient, Doctor doctorFound) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient) && appointment.getDoctor().equals(doctorFound)) {
                return appointment;
            }
        }
        return null;
    }

    public void printAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public int getNumberOfAppointments() {
        return appointments.size();
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public Appointment gAppointmentByID(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }
}
