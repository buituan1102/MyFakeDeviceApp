#!/bin/bash

mkdir -p /sdcard/MyNewApp/app/src/main/java/com/myfake/deviceapp
mkdir -p /sdcard/MyNewApp/app/src/main/res/layout
mkdir -p /sdcard/MyNewApp/.github/workflows

# MainActivity.java
cat > /sdcard/MyNewApp/app/src/main/java/com/myfake/deviceapp/MainActivity.java << 'EOL'
package com.myfake.deviceapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
EOL

# Thêm các file còn lại tại đây...
# (Mình sẽ gửi đầy đủ sau hoặc đính kèm luôn nếu bạn muốn dạng .zip)

echo "Hoàn tất tạo MainActivity.java. Đang chờ tạo tiếp các file khác..."
