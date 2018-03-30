package com.example.superman.bigmaptest;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

/**
 * evenbus
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 当我们需要在Activity或者Fragment里订阅事件时，我们需要注册EventBus。我们一般选择在Activity的onCreate()
     * 方法里去注册EventBus，在onDestory()方法里，去解除注册。
     *
     * @param savedInstanceState
     */
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        textView.setText("hello，girl");
        EventBus.getDefault().register(this);
    }



    public void open(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void close(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * MAIN 表示事件处理函数的线程在主线程(UI)线程，因此在这里不能进行耗时操作。
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void event(MessageEvent messageEvent) {
        textView.setText(messageEvent.getMessage());
    }
}
