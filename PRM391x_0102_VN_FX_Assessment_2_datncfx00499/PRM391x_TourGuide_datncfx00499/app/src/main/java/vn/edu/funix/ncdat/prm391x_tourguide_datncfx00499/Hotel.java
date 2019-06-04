package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

public class Hotel {
    private String name;
    private String address;
    private int image;
    private String phone;

    public Hotel(String name, String address, int image, String phone) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
