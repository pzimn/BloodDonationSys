package sample;

public class Donation {
    int id;
    int donorId;
    float bloodLitres;
    String date;
    int stationId;
    int bloodGroupId;

    public int getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }


    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + id +
                ", donorId='" + donorId + '\'' +
                ", bloodLitres='" + bloodLitres + '\'' +
                ", date=" + date +
                ", stationId='" + stationId + '\'' +
                ", bloodGroupId='" + bloodGroupId + '\'' +
                '}';
    }

    public Donation(int donorId, float bloodLitres, String date, int stationId, int bloodGroupId) {
        this.donorId = donorId;
        this.bloodLitres = bloodLitres;
        this.date = date;
        this.stationId = stationId;
        this.bloodGroupId = bloodGroupId;

    }

    public Donation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public float getBloodLitres() {
        return bloodLitres;
    }

    public void setBloodLitres(float bloodLitres) {
        this.bloodLitres = bloodLitres;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }
}