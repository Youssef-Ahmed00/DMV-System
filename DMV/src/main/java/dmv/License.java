package dmv;

import java.time.LocalDate;
import java.util.ArrayList;

public class License {
    private static final ArrayList<Integer> licenseNos = new ArrayList<>();
    private int licenseNo;
    private final String fullName;
    private final LocalDate birthDate;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private final LicenseClass classType;
    private LicenseStatus licenseStatus;
    private final Restriction restrictions;

    public License(int licenseNo ,String fullName, LocalDate birthDate, LocalDate issueDate, LocalDate expiryDate
            , LicenseStatus licenseStatus,LicenseClass classType, Restriction restrictions) {
        this.licenseNo = licenseNo;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.classType = classType;
        this.licenseStatus = LicenseStatus.ACTIVE;
        this.restrictions = restrictions;
    }

    public License(String fullName, LocalDate birthDate, LicenseClass ClassType, Restriction restrictions) {
        generateLicNo();
        this.fullName = fullName;
        this.birthDate = birthDate;
        issueDate = LocalDate.now();
        expiryDate = issueDate.plusYears(1);
        this.classType = ClassType;
        licenseStatus = LicenseStatus.ACTIVE;
        this.restrictions = restrictions;
    }

    private void generateLicNo() {
        int no;
        do {
            no = (int) (Math.random() * 899999 + 100000);
        } while (licenseNos.contains(no));
        licenseNos.add(no);
        this.licenseNo = no;
    }

    public void renewalLic() {
        issueDate = LocalDate.now();
        expiryDate = issueDate.plusYears(1);
        licenseStatus = LicenseStatus.ACTIVE;
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LicenseClass getClassType() {
        return classType;
    }

    public LicenseStatus getLicenseStatus() {return licenseStatus;}

    public void setLicenseStatus(LicenseStatus licenseStatus) {this.licenseStatus = licenseStatus;}

    public Restriction getRestrictions() {
        return restrictions;
    }
}
