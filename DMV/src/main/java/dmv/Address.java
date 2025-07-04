package dmv;

public class Address {
    private final int houseNo;
    private final String street;
    private final String governorate;
    private final String country;

     Address(int houseNo, String street, String governorate, String country) {
        this.houseNo = houseNo;
        this.street = street;
        this.governorate = governorate;
        this.country = country;
    }
    public String getAddress(){
         return " H "+houseNo+" -S "+street+" -G "+governorate+" -C "+country;
    }
}
