
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;


// TODO :
// change method findDoctorByName to findDoctorByID in AppointmentScheduler 
// change method findPatientByName to findPatientByID in cancelAppointment 
// try input InputMismatchException  on all menus
public class HealthcareAppMenu {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientRegistry patientRegistry = new PatientRegistry();
    private static final DoctorRegistry doctorRegistry = new DoctorRegistry();
    private static final AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
    private static final InsuranceProcessor insuranceProcessor = new InsuranceProcessor();
    private static final BillingProcessor billingProcessor = new BillingProcessor();

    //private static final InsuranceProcessorTest insuranceProcessorTest = new InsuranceProcessorTest();

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {
        try{
            Date date = new Date();

            ArrayList<Treatment> MedicalHistory1 = new ArrayList<>();
            ArrayList<Treatment> MedicalHistory2 = new ArrayList<>();
            ArrayList<Treatment> MedicalHistory3 = new ArrayList<>();

            Patient patient1 = new Patient("John Doe", date, 1, MedicalHistory1, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
            Patient patient2 = new Patient("Jane Doe", date, 2, MedicalHistory2, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
            Patient patient3 = new Patient("Bob Smith", date, 3, MedicalHistory3, "123 Main St", 123456, "12345", "Blue LOCAL", 123445);

            Doctor doctor1 = new Doctor(1,"John Smith", date, "1", "123 Main St", 5551234, 20, date, "Cardiology");
            Doctor doctor2 = new Doctor(2, "Jane Smith", date, "2", "123 Main St", 5551234, 20, date, "Cardiology");
            Doctor doctor3 = new Doctor(3, "Bob Doe", date, "3", "123 Main St", 5551234, 20, date, "Cardiology");

            Treatment treatment1 = new Treatment(patient1, doctor1, "Treatment 1", date);
            Treatment treatment2 = new Treatment(patient2, doctor2, "Treatment 2", date);
            Treatment treatment3 = new Treatment(patient3, doctor3, "Treatment 3", date);

            patient1.getMedicalHistory().add(treatment1);
            patient2.getMedicalHistory().add(treatment2);
            patient3.getMedicalHistory().add(treatment3);

            patientRegistry.addPatient(patient1);
            patientRegistry.addPatient(patient2);
            patientRegistry.addPatient(patient3);

            doctorRegistry.addDoctor(doctor1);
            doctorRegistry.addDoctor(doctor2);
            doctorRegistry.addDoctor(doctor3);

            int choice;
            do {
                System.out.println("===== Healthcare App Menu =====");
                System.out.println("Who are you?");
                System.out.println("1. Receptionist");
                System.out.println("2. Doctor");
                System.out.println("3. Finance");
                //System.out.println("4. Test Panel");
                System.out.println("0. Exit");


                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> receptionistMenu();
                    case 2 -> doctorMenu();
                    case 3 -> financeMenu();
                    //case 4 -> testPanel();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice, please try again.");
                }

                System.out.println();
            } while (choice != 0);
        }catch (InputMismatchException e){
            System.out.println("Error: enter a valid input");
        }
    }

    private static void financeMenu() throws ParseException {
        System.out.println("===== Healthcare App Menu =====");
        System.out.println("===== Finance Menu =====");
        System.out.println("1. Process insurance claim");
        System.out.println("2. Generate a new bill");
        System.out.println("3. Process a payment");
        System.out.println("4. View unpaid bills");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> processInsuranceClaim();
            case 2 -> generateBill();
            case 3 -> processPayment();
            case 4 -> viewUnpaidBills();
            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice, please try again.");
        }
    }

    private static void doctorMenu() throws ParseException, IOException, InterruptedException {
        clearScreen();
        System.out.println("===== Healthcare App Menu =====");
        System.out.println("===== Doctor Menu =====");
        System.out.println("1. Schedule a new appointment");
        System.out.println("2. Cancel an appointment");
        System.out.println("3. Verify insurance for a patient");
        System.out.println("4. View all patients");
        System.out.println("5. View all appointments");
        System.out.println("6. Add a Treatment");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> scheduleAppointment();
            case 2 -> cancelAppointment();
            case 3 -> verifyInsurance();
            case 4 -> viewAllPatient();
            case 5 -> viewAllAppointments();
            case 6 -> addTreatment();

            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice, please try again.");
        }

    }

   // private static void testPanel() {
//        insuranceProcessorTest.setUp();
//        insuranceProcessorTest.testVerifyInsuranceWithInvalidProvider();
//        insuranceProcessorTest.testVerifyInsuranceWithValidProvider();
//        insuranceProcessorTest.testProcessClaimWithValidProvider();
//        insuranceProcessorTest.testProcessClaimWithInvalidProvider();

   // }

    private static void addTreatment() {
        System.out.println("===== Healthcare App Menu =====");
        System.out.println("===== Add Treatment =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient ID: ");
        int patientID = scanner.nextInt();
        Patient patient = patientRegistry.getPatient(patientID);
        System.out.println("Enter the treatment: ");
        String treatmentDescription = scanner.next();
        doctorRegistry.printAllDoctors();
        System.out.println("Enter the doctor ID: ");
        int doctorID = scanner.nextInt();
        Doctor doctor = doctorRegistry.getDoctor(doctorID);
        System.out.println("Enter the date: ");
        String date1 = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(date1);
        } catch (ParseException e) {
            // Handle invalid date format
            System.out.println("Invalid date format. Please try again.");
            return;
        }
        Treatment treatment = new Treatment(patient,  doctor, treatmentDescription, date);
        patient.getMedicalHistory().add(treatment);
        patient.updateMedicalHistory(); // to print the medical history in a file
    }

    private static void viewAllAppointments() {
        appointmentScheduler.printAppointments();
    }

    private static void viewAllPatient() {
        patientRegistry.printPatients();
    }

    private static void receptionistMenu() throws ParseException {
        System.out.println("===== Healthcare App Menu =====");
        System.out.println("1. Register a new patient");
        System.out.println("2. Register a new doctor");
        System.out.println("3. Schedule a new appointment");
        System.out.println("4. Cancel an appointment");
        System.out.println("5. Verify insurance for a patient");
        System.out.println("6. Process insurance claim");
        System.out.println("7. Generate a new bill");
        System.out.println("8. Process a payment");
        System.out.println("9. View unpaid bills");
        System.out.println("10. View all patients");
        System.out.println("11. View all doctors");
        System.out.println("12. View all appointments");
        System.out.println("13. View all insurance providers");
        System.out.println("14. View all bills");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> registerPatient();
            case 2 -> registerDoctor();
            case 3 -> scheduleAppointment();
            case 4 -> cancelAppointment();
            case 5 -> verifyInsurance();
            case 6 -> processInsuranceClaim();
            case 7 -> generateBill();
            case 8 -> processPayment();
            case 9 -> viewUnpaidBills();
            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice, please try again.");
        }

    }

    // This method registers a new patient by prompting the user for various pieces of information
        private static void registerPatient() {
            System.out.println("===== Register Patient =====");

            // Ask for the patient's name
            System.out.print("Enter the patient's name: ");
            String name = scanner.next();

            // Check if the patient already exists
            if (patientRegistry.findPatientByName(name) != null) {
                System.out.println("Patient already exists.");
                return;
            }

            // Ask for the patient's date of birth
            System.out.println("Enter the patient's date of birth (dd-mm-yyyy) : ");
            String dob = scanner.next();

            // Parse the date of birth
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = formatter.parse(dob);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
            } catch (ParseException e) {
                // Handle invalid date format
                System.out.println("Invalid date format. Please try again.");
                return;
            }
            // Generate a patient ID
            int id = patientRegistry.getLastPatientID() + 1;
            System.out.println("The Patient ID is: " + id);

            // Ask for the patient's phone number

            System.out.println("Enter the patient's phone number: ");
            int phoneNumber;
            try {
                phoneNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Handle invalid phone number format
                System.out.println("Invalid phone number format. Please try again.");
                return;
            }

            // Ask for the patient's address
            System.out.println("Enter the patient's address: ");
            String address = scanner.next();

            // Ask for the patient's insurance provider
            System.out.println("Enter the patient's insurance provider: ");
            String insuranceProvider = scanner.next();

            // Ask for the patient's social security number
            System.out.println("Enter the patient's Social Security Number : ");
            int ssn;
            try {
                ssn = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Handle invalid social security number format
                System.out.println("Invalid Social Security Number format. Please try again.");
                return;
            }

            // Ask for the patient's employer
            System.out.println("Enter the patient's employer : ");
            String employer = scanner.next();

            // Create a new patient object and add it to the patient registry
            Patient patient = new Patient(name, date, id, null, address, phoneNumber, insuranceProvider, employer, ssn);
            patientRegistry.addPatient(patient);

            System.out.println("Patient registered successfully.");
        }

    private static void cancelAppointment() {
        //TODO
        System.out.println("Enter the patient's name: ");
        String patientName = scanner.next();

        // Find the patient by name
        Patient patient = patientRegistry.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        doctorRegistry.printAllDoctors();
        // Prompt user to enter doctor's ID
        System.out.println("Enter the doctor's ID: ");
        int doctorID = scanner.nextInt();
        Doctor doctor = doctorRegistry.findDoctorByID(doctorID);

        // Find the appointment for the patient and doctor
        Appointment appointment = appointmentScheduler.findAppointment(patient, doctor);
        if (appointment == null) {
            System.out.println("No matching appointment found.");
            return;
        }

        // Cancel the appointment
        appointmentScheduler.cancelAppointment(appointment);
        System.out.println("Appointment cancelled successfully.");
    }

    private static void registerDoctor() {
        // TODO: Implement this method
        System.out.println("===== Register Doctor =====");
        System.out.println("Enter the doctor's name: ");
        String name = scanner.next();
        System.out.println("Enter the doctor's last name :");
        String lastName = scanner.next();
        int doctorID = doctorRegistry.getNumberOfDoctors() + 1;
        System.out.println("The Doctor ID is: " + doctorID);
        System.out.println("Enter the doctor's specialty: ");
        String specialty = scanner.next();
        System.out.println("Enter the doctor's date of birth : ");
        String dob = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dob);
        } catch (ParseException e) {
            // Handle invalid date format
            System.out.println("Invalid date format. Please try again.");
            return;
        }
        System.out.println("Enter the doctor's phone number: ");
        int phoneNumber;
        try {
            phoneNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Handle invalid phone number format
            System.out.println("Invalid phone number format. Please try again.");
            return;
        }
        System.out.println("Enter the doctor's address: ");
        String address = scanner.next();
        System.out.println("Enter the doctor's seneriority : ");
        int seniority;
        try {
            seniority = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Handle invalid seniority format
            System.out.println("Invalid seniority format. Please try again.");
            return;
        }
        System.out.println("Enter the doctor's date of employment : ");
        String doj = scanner.next();
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;
        try {
            date1 = formatter1.parse(doj);
        } catch (ParseException e) {
            // Handle invalid date format
            System.out.println("Invalid date format. Please try again.");
            return;
        }
        Doctor doctor = new Doctor(doctorID, name, date, lastName, address, phoneNumber, seniority, date1, specialty);
        doctorRegistry.addDoctor(doctor);
        System.out.println("Doctor registered successfully.");
    }
    private static void scheduleAppointment() throws ParseException {
        AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
        System.out.println("===== Schedule Appointment =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
            if (patient == null) {
                System.out.println("No matching patients found.");
                return;
            }
            doctorRegistry.printAllDoctors();
        System.out.println("Enter the doctor's ID: ");
        int doctorID = scanner.nextInt();
        Doctor doctorFound = doctorRegistry.findDoctorByID(doctorID);
        System.out.println("Enter the date of the appointment (dd-mm-yyyy) : ");
        String date = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date dateOfAppointment = formatter.parse(date);
        System.out.println("Enter the duration of the appointment: ");
        int duration  = scanner.nextInt();
        System.out.println("Enter the price of the appointment: ");
        int price = scanner.nextInt();
        appointmentScheduler.scheduleAppointment(patient, doctorFound, dateOfAppointment , price, duration);
    }

    private static void verifyInsurance() {
        System.out.println("===== Verify Insurance =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        if (insuranceProcessor.verifyInsurance(patient.getInsuranceCompany(), patient)){
            System.out.println("Insurance verified successfully.");
        } else {
            System.out.println("Insurance verification failed.");
        }
    }

    private static void processInsuranceClaim() {
        System.out.println("===== Process Insurance Claim =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        billingProcessor.printUpnaidBillByPatientId(ID);
        System.out.println("Enter the bill ID: ");
        int billID = scanner.nextInt();
        Bill bill = billingProcessor.getBillById(billID);
        if (bill == null) {
            System.out.println("No matching bills found.");
            return;
        }
        double amount = bill.getAmount();
        if (insuranceProcessor.processClaim(patient.getInsuranceCompany(),patient, amount)){
            System.out.println("Insurance claim processed successfully.");
        } else {
            System.out.println("Insurance claim processing failed.");
        }
    }

    private static void generateBill() throws ParseException {
        // TODO: Implement this method
        System.out.println("===== Generate Bill =====");
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        System.out.println("Enter the date of the appointment (dd-mm-yyyy) : ");
        String date = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date dateOfAppointment = null;
        try {
            dateOfAppointment = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter the amount of the appointment: ");
        int amount = scanner.nextInt();


        billingProcessor.generateBill(patient, dateOfAppointment, amount);
    }

    private static void processPayment() {
        // TODO: Implement this method
        System.out.println("===== Process Payment =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        billingProcessor.printUnpaidBillsByPatient(patient);
        System.out.println("Enter the bill ID: ");
        int billId = scanner.nextInt();
        Bill bill = billingProcessor.getBillById(billId);
        if (bill == null) {
            System.out.println("No matching bills found.");
            return;
        }
        System.out.println("Enter the amount to be paid: ");
        int amount = scanner.nextInt();
        billingProcessor.processPayment(bill, amount);
        billingProcessor.getAmountToPayByBillID(billId);
    }

    private static void viewUnpaidBills() {

        System.out.println("===== View Unpaid Bills =====");
        patientRegistry.printPatients();
        System.out.println("Enter the patient's ID: ");
        int ID = scanner.nextInt();
        Patient patient = patientRegistry.findPatientByID(ID);
        if (patient == null) {
            System.out.println("No matching patients found.");
            return;
        }
        billingProcessor.printUnpaidBillsByPatient(patient);
        System.out.println("Do you want to pay a bill (y or n) : ");
        String choice = scanner.next();
        if (choice.equals("y")) {
            System.out.println("Enter the bill ID: ");
            int billId = scanner.nextInt();
            Bill bill = billingProcessor.getBillById(billId);
            if (bill == null) {
                System.out.println("No matching bills found.");
                return;
            }
            System.out.println("Enter the amount to be paid: ");
            int amount = scanner.nextInt();
            billingProcessor.processPayment(bill, amount);
            billingProcessor.getAmountToPayByBillID(billId);
        }
        else {
            return;
        }

    }
}
