import java.util.HashMap;
import java.util.Map;

public class InsuranceProcessor {
    private Map<String, InsuranceProvider> insuranceProviders;

    public InsuranceProcessor() {
        insuranceProviders = new HashMap<>();
    }

    public void addInsuranceProvider(String providerName, String providerNumber, String phone, int maximumCoverage) {
        InsuranceProvider provider = new InsuranceProvider(providerName, providerNumber, phone, maximumCoverage);
        insuranceProviders.put(providerNumber, provider);
    }

    public boolean verifyInsurance(String providerNumber, Patient patient) {
        InsuranceProvider provider = insuranceProviders.get(providerNumber);
        if (provider == null) {
            return false;
        }
        return provider.verifyInsurance(patient);
    }

    public boolean processClaim(String providerName, Patient patient, double amount) {
        InsuranceProvider provider = insuranceProviders.get(providerName);
        if (provider == null) {
            return false;
        }
        return provider.processClaim(patient, amount);
    }
    public int getNumberOfProviders() {
        return insuranceProviders.size();
    }
}

