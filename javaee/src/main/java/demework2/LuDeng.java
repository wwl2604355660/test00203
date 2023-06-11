package demework2;

public class LuDeng {
    private String ludeng;
    private String id;
    private String address;

    public String getLudeng() {
        return ludeng;
    }

    public void setLudeng(String ludeng) {
        this.ludeng = ludeng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LuDeng{" +
                "ludeng='" + ludeng + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
