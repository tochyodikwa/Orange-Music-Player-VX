package com.tochycomputerservices.orangeplayer.vx.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tochycomputerservices.orangeplayer.vx.Common;
import com.tochycomputerservices.orangeplayer.vx.Utils.Constants;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    private Common mCommon;

    @Override
    public void onReceive(Context context, Intent intent) {
        mCommon = (Common) context.getApplicationContext();

        if (intent.hasExtra("INDEX")) {
            if (mCommon.isServiceRunning()) {
                mCommon.getService().setSelectedSong(intent.getExtras().getInt("INDEX"));
            }
            return;
        }

        try {
            String action = intent.getAction();
            if (action.equalsIgnoreCase(Constants.ACTION_NEXT)) {
                mCommon.getService().nextSong();
            } else if (action.equalsIgnoreCase(Constants.ACTION_PAUSE)) {
                mCommon.getService().playPauseSong();
            } else if (action.equalsIgnoreCase(Constants.ACTION_PREVIOUS)) {
                mCommon.getService().previousSong();
            } else if (action.equalsIgnoreCase(Constants.ACTION_STOP)) {
                mCommon.getService().stopSelf();
            }
        } catch (Exception e) {
        }
    }
}