package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.service.AlarmService;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String keyStatus = intent.getStringExtra("keyStatus");
        Intent mIntent = new Intent(context, AlarmService.class);
        mIntent.putExtra("keyStatus", keyStatus);
        context.startService(mIntent);
    }
}