import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillingProcessor {
    private List<Bill> bills;

    public BillingProcessor() {
        bills = new ArrayList<>();
    }

    public void  generateBill(Patient patient, Date date, double amount) {
        Bill bill = new Bill(patient, date, amount, bills.size() + 1);
        bills.add(bill);
    }

    public Bill getBillById(int billId) {
        for (Bill bill : bills) {
            if (bill.getBillId() == billId) {
                return bill;
            }
        }
        return null;
    }
    public void processPayment(Bill bill, double paymentAmount) {
        bill.processPayment(paymentAmount);
    }

    public List<Bill> getUnpaidBills() {
        List<Bill> unpaidBills = new ArrayList<>();
        for (Bill bill : bills) {
            if (!bill.isPaid()) {
                unpaidBills.add(bill);
            }
        }
        return unpaidBills;
    }

    public void printBills() {
        for (Bill bill : bills) {
            System.out.println("Patient: " + bill.getPatient().getName());
            System.out.println("Date: " + bill.getDate());
            System.out.println("Amount: " + bill.getAmount());
            System.out.println("Amount paid: " + bill.getAmountPaid());
            System.out.println("Balance: " + bill.getBalance());
            System.out.println("ID : " + bill.getBillId());
            System.out.println();
        }
    }
    public void printUnpaidBillsByPatient(Patient patient) {
        for (Bill bill : bills) {
            if (bill.getPatient().equals(patient) && !bill.isPaid()) {
                System.out.println("Patient: " + bill.getPatient().getName());
                System.out.println("Date: " + bill.getDate());
                System.out.println("Amount: " + bill.getAmount());
                System.out.println("Amount paid: " + bill.getAmountPaid());
                System.out.println("Balance: " + bill.getBalance());
                System.out.println("ID : " + bill.getBillId());
                System.out.println();
            }
        }
    }
    public void getAmountToPayByBillID(int billId) {
        for (Bill bill : bills) {
            if (bill.getBillId() == billId) {
                System.out.println("Amount to pay: " + bill.getBalance());
            }
        }
    }



    public void printUpnaidBillByPatientId(int patientId) {
        for (Bill bill : bills) {
            if (bill.getPatient().getPatientId() == patientId && !bill.isPaid()) {
                System.out.println("Patient: " + bill.getPatient().getName());
                System.out.println("Date: " + bill.getDate());
                System.out.println("Amount: " + bill.getAmount());
                System.out.println("Amount paid: " + bill.getAmountPaid());
                System.out.println("Balance: " + bill.getBalance());
                System.out.println("ID : " + bill.getBillId());
                System.out.println();
            }
        }
    }
}