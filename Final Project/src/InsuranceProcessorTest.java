//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class InsuranceProcessorTest {
//    private InsuranceProcessor insuranceProcessor;
//    Date date = new Date();
//    @Before
//    public void setUp() {
//        insuranceProcessor = new InsuranceProcessor();
//        insuranceProcessor.addInsuranceProvider("Provider A", "123456", "555-555-5555", 1000);
//    }
//
//    @Test
//    public void testVerifyInsuranceWithValidProvider() {
//        Patient patient1 = new Patient("John Doe", date, 1, null, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
//        assertTrue(insuranceProcessor.verifyInsurance("123456", patient1));
//    }
//
//    @Test
//    public void testVerifyInsuranceWithInvalidProvider() {
//        Patient patient1 = new Patient("John Doe", date, 1, null, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
//        assertFalse(insuranceProcessor.verifyInsurance("999999", patient1));
//    }
//
//    @Test
//    public void testProcessClaimWithValidProvider() {
//        Patient patient = new Patient("John Doe", date, 1, null, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
//        double amount = 100.0;
//        assertTrue(insuranceProcessor.processClaim("123456", patient, amount));
//    }
//
//    @Test
//    public void testProcessClaimWithInvalidProvider() {
//        Patient patient = new Patient("John Doe", date, 1, null, "123 Main St", 5551234, "Blue Cross", "12345",  123445);
//        double amount = 100.0;
//        assertFalse(insuranceProcessor.processClaim("999999", patient, amount));
//    }
//}
