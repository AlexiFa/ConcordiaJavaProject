public class InsuranceProvider {
    private final String providerName;
    private final String providerNumber;
    private final String phone;
    private final int maximumCoverage;

    public InsuranceProvider(String providerName, String providerNumber, String phone, int maximumCoverage ) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.phone = phone;
        this.maximumCoverage = maximumCoverage;
    }

    public boolean verifyInsurance(Patient patient) {
        // Implementation details omitted
        String insuranceCompany = patient.getInsuranceCompany();
        if (insuranceCompany == null) {
            return false;
        }
        if (insuranceCompany.equals(providerName)) {
            return true;
        }
        return true;
    }

    public boolean processClaim(Patient patient, double amount) {
        if(verifyInsurance(patient)) {
            return amount <= maximumCoverage;
        }
        return false;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public String getPhone() {
        return phone;
    }
}
