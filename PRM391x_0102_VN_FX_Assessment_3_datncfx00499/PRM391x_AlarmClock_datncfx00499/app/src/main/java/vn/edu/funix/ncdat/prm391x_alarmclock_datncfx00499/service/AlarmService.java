package vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import vn.edu.funix.ncdat.prm391x_alarmclock_datncfx00499.R;


public class AlarmService extends Service {

    MediaPlayer ringTone;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String keyStatus = intent.getStringExtra("keyStatus");
        if (keyStatus.equals("On")) {
            ringTone = MediaPlayer.create(this, R.raw.music);
            ringTone.start();
        } else if (keyStatus.equals("Off")) {
            ringTone.stop();
            ringTone.reset();
        }
        return START_NOT_STICKY;
    }
}