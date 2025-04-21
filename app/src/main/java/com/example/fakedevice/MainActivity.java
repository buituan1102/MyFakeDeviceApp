package com.example.fakedevice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView fakeInfo;
    Button showFake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fakeInfo = findViewById(R.id.fakeInfo);
        showFake = findViewById(R.id.btnFake);

        showFake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FakeDeviceManager fdm = new FakeDeviceManager();
                fakeInfo.setText(fdm.getFakeInfo());
            }
        });
    }
}
