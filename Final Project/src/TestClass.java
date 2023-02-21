import java.util.Date;

public class TestClass {
    public static void main(String[] args) {
        Date date = new Date();
        date.setYear(2020);
        date.setMonth(10);
        date.setDate(10);
        // Create some doctors
        Doctor jane = new Doctor(1, "Jane Doe", date, "Pablo" , "87 avenue de ta mere", 5555678, 20, date, "Cardiology");
        Doctor john = new Doctor(2, "John Doe", date, "Pablo" , "87 avenue de ta mere", 5555678, 20, date, "Cardiology");

        // Create some patients
        Patient bob = new Patient("Bob Jones", date, 555-1234, null, "123 Main St", 5551234,  "MAAF", "12345",  123445);
        Patient lisa = new Patient("Lisa Smith", date, 555-4321, null, "123 Main St", 5551234,  "MAAF", "12345",  123445);
        // Schedule some appointments
        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.scheduleAppointment( bob, john, new Date(), 100, 30, 1);
        scheduler.scheduleAppointment(lisa, jane, new Date(), 150, 60, 2);

        // Verify insurance
        InsuranceProcessor processor = new InsuranceProcessor();
        processor.addInsuranceProvider("Blue Cross", "12345", "555-9999", 1000);
        boolean insuranceVerified = processor.verifyInsurance("12345", bob);
        System.out.println("Insurance verified: " + insuranceVerified);

        // Generate bills and process payments
        BillingProcessor billingProcessor = new BillingProcessor();
        billingProcessor.generateBill(bob, new Date(), 100);
        billingProcessor.generateBill(lisa, new Date(), 150);
        Bill bobBill = billingProcessor.getUnpaidBills().get(0);
        Bill lisaBill = billingProcessor.getUnpaidBills().get(1);
        billingProcessor.processPayment(bobBill, 50);
        billingProcessor.processPayment(lisaBill, 150);
        System.out.println("Bob's bill balance: " + bobBill.getBalance());
        System.out.println("Lisa's bill balance: " + lisaBill.getBalance());
    }
}
