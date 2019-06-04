package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ToggleButton;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.adapter.AlarmAdapter;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.data.DataBase;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.model.AlarmClock;

public class MainActivity extends AppCompatActivity {

    DataBase db;
    ToggleButton btnStatusAlarm;
    ListView lvAlarm;
    List<AlarmClock> arrAlarmClock;
    AlarmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        setAdapter();

    }

    // Set on click for image view addAlarm
    public void addAlarm(View view) {
        Intent mIntent = new Intent(MainActivity.this, AddAlarmClock.class);
        startActivity(mIntent);
    }

    // Add all controls
    public void addControls() {
        db = new DataBase(this);
        lvAlarm = findViewById(R.id.lvAlarm);
        btnStatusAlarm = findViewById(R.id.btnStatusAlarm);
        arrAlarmClock = db.getAllAlarmClock();
    }

    // Set adapter for listview
    public void setAdapter() {
        if (adapter == null) {
            adapter = new AlarmAdapter(this, R.layout.row_alarm, arrAlarmClock);
            lvAlarm.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
            lvAlarm.setSelection(adapter.getCount() - 1);
        }
    }
}