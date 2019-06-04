package vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.model;

public class History {

    private int mID;
    private String mOrigin;
    private String mDest;

    public History() {}

    public History(String mOrigin, String mDest) {
        this.mOrigin = mOrigin;
        this.mDest = mDest;
    }

    public History(int mID, String mOrigin, String mDest) {
        this.mID = mID;
        this.mOrigin = mOrigin;
        this.mDest = mDest;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmOrigin() {
        return mOrigin;
    }

    public void setmOrigin(String mOrigin) {
        this.mOrigin = mOrigin;
    }

    public String getmDest() {
        return mDest;
    }

    public void setmDest(String mDest) {
        this.mDest = mDest;
    }

}
