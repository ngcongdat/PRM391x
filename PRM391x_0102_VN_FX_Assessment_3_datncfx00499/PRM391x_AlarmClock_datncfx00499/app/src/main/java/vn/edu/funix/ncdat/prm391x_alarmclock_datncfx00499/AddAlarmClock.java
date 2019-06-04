package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.data.DataBase;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.model.AlarmClock;

public class AddAlarmClock extends AppCompatActivity {

    private static final String PM = "PM";
    private static final String AM = "AM";
    Intent mIntent;
    TimePicker timePicker;
    Button btnAdd;
    DataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm_clock);

        addControls();
        addEvents();

    }

    // Set event for time picker and add alarm to database
    private void addEvents() {
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, final int hourOfDay, final int minute) {
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (hourOfDay >= 12) {
                            db.addAlarmClock(new AlarmClock(hourOfDay, minute, PM, false));
                        } else {
                            db.addAlarmClock(new AlarmClock(hourOfDay, minute, AM, false));
                        }
                        startActivity(mIntent);
                    }
                });
            }
        });
    }

    // Add all controls
    private void addControls() {
        mIntent = new Intent(AddAlarmClock.this, MainActivity.class);
        timePicker = findViewById(R.id.timePicker);
        btnAdd = findViewById(R.id.btnAdd);
        db = new DataBase(this);
    }

    // Set on click for image view imgBack
    public void imgBack(View view) {
        startActivity(mIntent);
    }
}