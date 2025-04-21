package com.example.fakedevice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FakeDeviceManager faker = new FakeDeviceManager();

        String info = "IMEI: " + faker.generateRandomIMEI() + "\n" +
                      "MAC: " + faker.generateRandomMAC() + "\n" +
                      "Serial: " + faker.generateRandomSerial();

        TextView textView = findViewById(R.id.textInfo);
        textView.setText(info);
    }
}
