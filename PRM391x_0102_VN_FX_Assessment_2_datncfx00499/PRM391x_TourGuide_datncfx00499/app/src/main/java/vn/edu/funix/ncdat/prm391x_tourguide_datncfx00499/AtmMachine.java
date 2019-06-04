package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

public class AtmMachine {
    private String name;
    private String address;
    private int image;
    private String openningHours;

    public AtmMachine(String name, String address, int image, String openningHours) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.openningHours = openningHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getOpenningHours() {
        return openningHours;
    }

    public void setOpenningHours(String phone) {
        this.openningHours = openningHours;
    }
}
