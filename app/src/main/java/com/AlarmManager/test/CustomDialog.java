package com.AlarmManager.test;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.util.Calendar;
import android.view.View;
import android.view.Window;

public class CustomDialog extends Dialog {
    private Context context;
    public CustomDialog(Context context) {
        super(context);
        init();
        this.context = context;
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarm = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
                //실행할 브로드캐스트 리시버에 대한 액션명을 지정해서 인텐트 만들어줌
                // - 이 인텐트는 알람메니저에 의해서 실행
                Intent i = new Intent(MainActivity.ALARM_MANAGER);
                //알람매니저에게 의뢰해야 하므로 팬딩인텐트로 작업
                PendingIntent pintent =
                        PendingIntent.getBroadcast(context, 0, i, 0);

                //알람메니저가 실행될 시간과 알람메니저에 의해서 실행될 인텐트를 셋팅
                alarm.set(AlarmManager.RTC,  System.currentTimeMillis() + 5000, pintent);
            }
        });
    }
}
