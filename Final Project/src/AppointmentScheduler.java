import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentScheduler {
    private List<Appointment> appointments;

    public AppointmentScheduler() {
        appointments = new ArrayList<>();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void scheduleAppointment(Patient patient, Doctor doctor, Date date, int price, int duration) {
        Appointment appointment = new Appointment(date, doctor, patient, price, duration);
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
}
