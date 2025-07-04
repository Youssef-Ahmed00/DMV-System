package dmv;

import java.time.LocalDate;
import java.util.ArrayList;

public class Citizen {
    private final int nationalID;
    private final String fullName;
    private final LocalDate birthDate;
    private final Gender gender;
    private final MaritalStatus maritalStatus;
    private final Religion religion;
    private final Address address;
    ArrayList<License> licenses;

    public Citizen(String fullName, int nationalID, int houseNo, String street, String governorate, String county, LocalDate date, Gender gender, MaritalStatus maritalStatus, Religion religion) {
        this.nationalID = nationalID;
        this.fullName = fullName;
        this.birthDate = date;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.address = new Address(houseNo, street, governorate, county);
        licenses = new ArrayList<>();
    }

    public void addLicense(LicenseClass type, Restriction rest) {
        licenses.add(new License(fullName, birthDate, type, rest));
    }
    public void addLicense(int licenseNo ,String fullName, LocalDate birthDate, LocalDate issueDate, LocalDate expiryDate
            , LicenseStatus licenseStatus,LicenseClass classType, Restriction restrictions){
        licenses.add(new License (licenseNo, fullName, birthDate, issueDate, expiryDate, licenseStatus, classType, restrictions));
    }


    public ArrayList<License> getLicenses() {
        return licenses;
    }

    public int getNationalID() {
        return nationalID;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public Religion getReligion() {
        return religion;
    }
    public Address getAddress() {
        return address;
    }
}
