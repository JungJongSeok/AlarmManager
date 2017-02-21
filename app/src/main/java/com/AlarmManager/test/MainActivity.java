package com.AlarmManager.test;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Context context = this;

    public static String ALARM_MANAGER = "alarm_manager";
    private AlarmReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ALARM_MANAGER);

        intentFilter.addAction("android.intent.action.BOOT_COMPLETED");

        mReceiver = new AlarmReceiver();
        registerReceiver(mReceiver, intentFilter);

        findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = new CustomDialog(context);
                dialog.show();
            }
        });
    }
}
