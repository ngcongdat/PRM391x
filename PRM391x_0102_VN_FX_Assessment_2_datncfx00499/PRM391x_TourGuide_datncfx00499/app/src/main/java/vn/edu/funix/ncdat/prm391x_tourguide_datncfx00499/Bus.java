package vn.edu.funix.ncdat.prm391x_tourguide_datncfx00499;

public class Bus {
    private String route;
    private String address;
    private int image;
    private String price;

    public Bus(String route, String address, int image, String price) {
        this.route = route;
        this.address = address;
        this.image = image;
        this.price = price;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
