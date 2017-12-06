package sample;

public class Blood_group {

    private int id;
    private String group;

    public Blood_group(String group) {
        //this.bloodGroupId = bloodGroupId;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Blood_group{" +
                "BloodGroupId=" + id +
                ", group='" + group + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
