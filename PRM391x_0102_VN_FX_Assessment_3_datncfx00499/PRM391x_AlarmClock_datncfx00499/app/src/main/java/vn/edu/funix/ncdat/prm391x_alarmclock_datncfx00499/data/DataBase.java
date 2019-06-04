package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.model.AlarmClock;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alarmclock_manager.sqlite";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "alarmclock";
    private static final String ID = "ID";
    private static final String HOURS = "HOURS";
    private static final String MINUTES = "MINUTES";
    private static final String MIDDAY = "MIDDAY";
    private static final String STATUS = "STATUS";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                HOURS + " INTEGER, " +
                MINUTES + " INTEGER, " +
                MIDDAY + " TEXT, " +
                STATUS + " BOOLEAN)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    // Method to write and add new alarm data
    public void addAlarmClock (AlarmClock alarmClock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HOURS, alarmClock.getmHours());
        values.put(MINUTES, alarmClock.getmMinutes());
        values.put(MIDDAY, alarmClock.getmMidday());
        values.put(STATUS, alarmClock.ismStatus());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Method to read and get all alarm data
    public List<AlarmClock> getAllAlarmClock() {
        List<AlarmClock> listAlarmClock = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do {
                AlarmClock alarmClock = new AlarmClock();
                alarmClock.setmID(cursor.getInt(0));
                alarmClock.setmHours(cursor.getInt(1));
                alarmClock.setmMinutes(cursor.getInt(2));
                alarmClock.setmMidday(cursor.getString(3));
                if (cursor.getInt(4) == 1) {
                    alarmClock.setmStatus(true);
                } else alarmClock.setmStatus(false);
                listAlarmClock.add(alarmClock);
            } while (cursor.moveToNext());
        }
        db.close();
        return listAlarmClock;
    }

    // Method to edit alarm data in database
    public int editAlarm(AlarmClock alarmClock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HOURS, alarmClock.getmHours());
        values.put(MINUTES, alarmClock.getmMinutes());
        values.put(MIDDAY, alarmClock.getmMidday());
        values.put(STATUS, alarmClock.ismStatus());
        return db.update(TABLE_NAME, values, ID + "=?", new String[]{String.valueOf(alarmClock.getmID())});
    }

    // Method to delete alarm data in database
    public void deleteAlarm(AlarmClock alarmClock) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(alarmClock.getmID())});
    }
}