package vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_googlemap_datncfx00499.model.History;

public class DBHistory extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "history_manager.sqlite";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "history";
    private static final String ID = "ID";
    private static final String ORIGIN = "ORIGIN";
    private static final String DESTINATION = "DESTINATION";

    public DBHistory(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    // Create table in database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                ORIGIN + " TEXT, " +
                DESTINATION + " TEXT)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Method add history to database
    public void addHistory(History history) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ORIGIN, history.getmOrigin());
        values.put(DESTINATION, history.getmDest());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Method query history from database
    public List<History> getHistory() {
        List<History> listHistories = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                History history = new History();
                history.setmID(cursor.getInt(0));
                history.setmOrigin(cursor.getString(1));
                history.setmDest(cursor.getString(2));
                listHistories.add(history);
            } while (cursor.moveToNext());
        }
        db.close();
        return listHistories;
    }

    // Method delete in database
    public void deleteHistory(History history) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(history.getmID())});
    }
}
