package sample;

public class Hospital {

    private int id;
    private String hospitalName;
    private String hospitalAddress;
    private String phoneNumber;

    public Hospital(int id, String hospitalName, String hospitalAddress, String phoneNumber) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
