package sample;

public class Storage {

    int id;
    int stationId;
    float bloodValue;
    int bloodGroupId;
    String phoneNumber;
	String address;

    @Override
    public String toString() {
        return "Storage{" +
                "storageId=" + id +
                ", stationId='" + stationId + '\'' +
                ", bloodValue='" + bloodValue + '\'' +
                ", bloogGroupId=" + bloodGroupId +
                '}';
    }

    public Storage(int id, int stationId, float bloodValue, int bloodGroupId, String phoneNumber, String address) {
        this.id = id;
        this.stationId = stationId;
        this.bloodValue = bloodValue;
        this.bloodGroupId = bloodGroupId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Storage(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public float getBloodValue() {
        return bloodValue;
    }

    public void setBloodValue(float bloodValue) {
        this.bloodValue = bloodValue;
    }

    public int getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
