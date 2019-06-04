package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.adapter;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.Calendar;
import java.util.List;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.R;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.data.DataBase;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.model.AlarmClock;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.receiver.AlarmReceiver;

public class AlarmAdapter extends BaseAdapter {

    private static final String PM = "PM";
    private static final String AM = "AM";
    private Context context;
    private int layout;
    private List<AlarmClock> listAlarmClock;
    ImageView imgEditAlarm, imgDeleteAlarm;
    DataBase db;

    public AlarmAdapter(Context context, int layout, List<AlarmClock> listAlarmClock) {
        this.context = context;
        this.layout = layout;
        this.listAlarmClock = listAlarmClock;
        db = new DataBase(context);
    }

    @Override
    public int getCount() {
        return listAlarmClock.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtHours = convertView.findViewById(R.id.txtHours);
        TextView txtAmPm = convertView.findViewById(R.id.txtAmPm);
        final ToggleButton btnStatusAlarm = convertView.findViewById(R.id.btnStatusAlarm);

        final AlarmClock alarmClock = listAlarmClock.get(position);
        final int timeHours = alarmClock.getmHours();
        final int timeMinutes = alarmClock.getmMinutes();
        if (timeMinutes >= 10) {
            if (timeHours > 12) {
                txtHours.setText(String.valueOf(timeHours - 12) + ":" + String.valueOf(timeMinutes));
            } else {
                txtHours.setText(String.valueOf(timeHours) + ":" + String.valueOf(timeMinutes));
            }
        } else {
            if (timeHours > 12) {
                txtHours.setText(String.valueOf(timeHours - 12) + ":" + "0" + String.valueOf(timeMinutes));
            } else {
                txtHours.setText(String.valueOf(timeHours) + ":" + "0" + String.valueOf(timeMinutes));
            }
        }
        txtAmPm.setText(alarmClock.getmMidday());
        btnStatusAlarm.setChecked(alarmClock.ismStatus());

        // Set on check change event for button btnStatusAlarm to on/off alarm clock
        btnStatusAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent mIntent = new Intent(context, AlarmReceiver.class);
                PendingIntent pendingIntent;
                if (isChecked) {
                    Calendar calendar = Calendar.getInstance();
                    long temp = calendar.getTimeInMillis();
                    calendar.set(Calendar.HOUR_OF_DAY, timeHours);
                    calendar.set(Calendar.MINUTE, timeMinutes);
                    calendar.set(Calendar.SECOND, 0);

                    // Check time, if over alarm time, set alarm to next day
                    if (calendar.getTimeInMillis() < temp) {
                        calendar.add(Calendar.DATE, 1);
                    }

                    // Put key on to alarm receiver
                    mIntent.putExtra("keyStatus", "On");
                    pendingIntent = PendingIntent.getBroadcast(context, alarmClock.getmID(), mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
                if (!isChecked) {
                    pendingIntent = PendingIntent.getBroadcast(context, alarmClock.getmID(), mIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    // Put key off  to alarm receiver
                    mIntent.putExtra("keyStatus", "Off");

                    // Cancel alarm manager and pending intent
                    alarmManager.cancel(pendingIntent);
                    pendingIntent.cancel();

                    Calendar calendar = Calendar.getInstance();
                    long temp = calendar.getTimeInMillis();
                    calendar.set(Calendar.HOUR_OF_DAY, timeHours);
                    calendar.set(Calendar.MINUTE, timeMinutes);
                    calendar.set(Calendar.SECOND, 0);
                    long ringTime = temp - calendar.getTimeInMillis();
                    if (Math.abs(ringTime) < 60000 && temp > calendar.getTimeInMillis()) {
                        context.sendBroadcast(mIntent);
                    }
                }
            }
        });

        // Declare image view imgEditAlarm and imgDeleteAlarm
        imgEditAlarm = convertView.findViewById(R.id.imgEditAlarm);
        imgDeleteAlarm = convertView.findViewById(R.id.imgDeleteAlarm);

        // Set on click for image view imgDeleteAlarm to edit alarm data
        imgEditAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEditAlarm(alarmClock.getmID());
            }
        });

        // Set on click for image view imgDeleteAlarm to delete alarm data
        imgDeleteAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventDeleteAlarm(alarmClock.getmID());
            }
        });

        return convertView;
    }

    // Declare event to delete alarm in database
    private void eventDeleteAlarm(int id) {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.setmID(id);
        db.deleteAlarm(alarmClock);
        updateListView();
    }

    // Method show dialog to edit data alarm
    private void dialogEditAlarm(final int id) {
        // Declare a custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_edit_alarm_clock);

        TimePicker timePicker = dialog.findViewById(R.id.editTimePiker);
        final Button btnUpdateAlarm = dialog.findViewById(R.id.btnEditAlarm);
        Button btnCloseEdit = dialog.findViewById(R.id.btnCloseEdit);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, final int hourOfDay, final int minute) {
                btnUpdateAlarm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int result;
                        if (hourOfDay >= 12) {
                            result = db.editAlarm(new AlarmClock(id, hourOfDay, minute, PM, false));
                        } else {
                            result = db.editAlarm(new AlarmClock(id, hourOfDay, minute, AM, false));
                        }
                        dialog.dismiss();
                        if (result > 0) {
                            updateListView();
                        } else {
                            Toast.makeText(context, "Error!!! Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnCloseEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                updateListView();
            }
        });
        dialog.show();
    }

    // Update list view again
    private void updateListView() {
        listAlarmClock.clear();
        listAlarmClock.addAll(db.getAllAlarmClock());
        notifyDataSetChanged();
    }
}
