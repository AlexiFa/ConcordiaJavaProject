//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AppointmentSchedulerTest {
//    private AppointmentScheduler scheduler;
//    private Doctor doctor1;
//    private Doctor doctor2;
//    private Patient patient1;
//    private Patient patient2;
//    private Date date1;
//    private Date date2;
//
//    @BeforeEach
//    void setUp() {
//        scheduler = new AppointmentScheduler();
//        Doctor doctor1 = new Doctor(1, "Bob Doe", date1, "3", "123 Main St", 5551234, 20, date1, "Cardiology");
//        Doctor doctor2 = new Doctor(1,"John Smith", date2, "1", "123 Main St", 5551234, 20, date2, "Cardiology");
//
//        Patient patient1 = new Patient("Jane Doe", date2, 2, null, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
//        Patient patient2 = new Patient("Bob Smith", date1, 3, null, "123 Main St", 123456, "12345", "Blue LOCAL", 123445);
//        date1 = new Date();
//        date2 = new Date(date1.getTime() + 3600000); // 1 hour later
//    }
//
//    @Test
//    void testScheduleAndCancelAppointment() {
//        scheduler.scheduleAppointment(patient1, doctor1, date1, 100, 30);
//        assertEquals(1, scheduler.getAppointments().size());
//
//        Appointment appointment = scheduler.getAppointments().get(0);
//        assertEquals(patient1, appointment.getPatient());
//        assertEquals(doctor1, appointment.getDoctor());
//        assertEquals(date1, appointment.getDate());
//        assertEquals(100, appointment.getPrice());
//        assertEquals(30, appointment.getDuration());
//
//        scheduler.cancelAppointment(appointment);
//        assertEquals(0, scheduler.getAppointments().size());
//    }
//
//    @Test
//    void testGetAppointmentsByDoctor() {
//        scheduler.scheduleAppointment(patient1, doctor1, date1, 100, 30);
//        scheduler.scheduleAppointment(patient2, doctor1, date2, 150, 45);
//        scheduler.scheduleAppointment(patient1, doctor2, date1, 200, 60);
//
//        assertEquals(2, scheduler.getAppointmentsByDoctor(doctor1));
//        assertEquals(1, scheduler.getAppointmentsByDoctor(doctor2).size());
//    }
//
//    @Test
//    void testGetAppointmentsByPatient() {
//        scheduler.scheduleAppointment(patient1, doctor1, date1, 100, 30);
//        scheduler.scheduleAppointment(patient2, doctor1, date2, 150, 45);
//        scheduler.scheduleAppointment(patient1, doctor2, date1, 200, 60);
//
//        assertEquals(2, scheduler.getAppointmentsByPatient(patient1).size());
//        assertEquals(1, scheduler.getAppointmentsByPatient(patient2).size());
//    }
//
//    @Test
//    void testFindAppointment() {
//        scheduler.scheduleAppointment(patient1, doctor1, date1, 100, 30);
//        scheduler.scheduleAppointment(patient2, doctor1, date2, 150, 45);
//        scheduler.scheduleAppointment(patient1, doctor2, date1, 200, 60);
//
//        Appointment appointment = scheduler.findAppointment(patient1, doctor1);
//        assertEquals(patient1, appointment.getPatient());
//        assertEquals(doctor1, appointment.getDoctor());
//        assertEquals(date1, appointment.getDate());
//        assertEquals(100, appointment.getPrice());
//        assertEquals(30, appointment.getDuration());
//
//        appointment = scheduler.findAppointment(patient2, doctor2);
//        assertNull(appointment);
//
//        appointment = scheduler.findAppointment(patient1, doctor1);
//        assertNull(appointment);
//
//        appointment = scheduler.findAppointment(patient1, doctor2);
//        assertNull(appointment);
//    }
//}
