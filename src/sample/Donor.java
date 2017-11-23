package sample;

public class Donor {
    private int donorId;
    private String name;
    private String lastName;
    private int bloodGroupId;
    private String address;
    private String phoneNumber;

    public Donor(){}

    @Override
    public String toString() {
        return "Donor{" +
                "donorId=" + donorId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodGroupId=" + bloodGroupId +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Donor(String name, String lastName, int bloodGroupId, String address, String phoneNumber) {
        this.donorId = donorId;
        this.name = name;
        this.lastName = lastName;
        this.bloodGroupId = bloodGroupId;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Donor(String name, String lastName, String address, String phoneNumber) {
        this.donorId = donorId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
