package dmv;

public enum LicenseClass {
    A("Motorcycle"),
    B("Car"),
    C("Truck"),
    D("Bus"),
    E("Trailer"),
    F("Special purpose");

    private String description;

    LicenseClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
