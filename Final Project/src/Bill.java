import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Bill {
    private Patient patient;
    private Date date;
    private double amount;
    private double amountPaid;
    private final int billId ;

    public Bill(Patient patient, Date date, double amount, int billId) {
        this.patient = patient;
        this.date = date;
        this.amount = amount;
        this.amountPaid = 0.0;
        this.billId = billId;
    }

    public void processPayment(double paymentAmount) {
        amountPaid += paymentAmount;
    }

    public boolean isPaid() {
        return amountPaid >= amount;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return (int) (amount - amountPaid);
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    @Override
    public String toString() {
        return "Bill for " + patient.getName() + " for $" + amount + " on " + date;
    }


    public int getBillId() {
        return billId;
    }


}
