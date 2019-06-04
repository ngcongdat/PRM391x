package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.model;

public class AlarmClock {
    private int mID;
    private int mHours;
    private int mMinutes;
    private String mMidday;
    private boolean mStatus;

    public AlarmClock() {
    }

    public AlarmClock(int mHours, int mMinutes, String mMidday, boolean mStatus) {
        this.mHours = mHours;
        this.mMinutes = mMinutes;
        this.mMidday = mMidday;
        this.mStatus = mStatus;
    }

    public AlarmClock(int mID, int mHours, int mMinutes, String mMidday, boolean mStatus) {
        this.mID = mID;
        this.mHours = mHours;
        this.mMinutes = mMinutes;
        this.mMidday = mMidday;
        this.mStatus = mStatus;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public int getmHours() {
        return mHours;
    }

    public void setmHours(int mHours) {
        this.mHours = mHours;
    }

    public int getmMinutes() {
        return mMinutes;
    }

    public void setmMinutes(int mMinutes) {
        this.mMinutes = mMinutes;
    }

    public String getmMidday() {
        return mMidday;
    }

    public void setmMidday(String mMidday) {
        this.mMidday = mMidday;
    }

    public boolean ismStatus() {
        return mStatus;
    }

    public void setmStatus(boolean mStatus) {
        this.mStatus = mStatus;
    }
}