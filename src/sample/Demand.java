package sample;

public class Demand {
    int id;
    int storageId;
    int bloodGroupId;
    float quantity;

    @Override
    public String toString() {
        return "Demand{" +
                "demandId=" + id +
                ", storagenId='" + storageId + '\'' +
                ", bloodGroupId=" + bloodGroupId +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public Demand(int storageId, int bloodGroupId, float quantity) {
        //this.id = id;
        this.storageId = storageId;
        this.bloodGroupId = bloodGroupId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
