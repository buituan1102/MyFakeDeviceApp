package com.myfake.deviceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class FakeDeviceTab extends Fragment {

    private EditText editImei, editMac, editDeviceName, editAndroidVersion, editSerial;
    private Button btnFake, btnReset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fake_device, container, false);

        editImei = view.findViewById(R.id.editImei);
        editMac = view.findViewById(R.id.editMac);
        editDeviceName = view.findViewById(R.id.editDeviceName);
        editAndroidVersion = view.findViewById(R.id.editAndroidVersion);
        editSerial = view.findViewById(R.id.editSerial);
        btnFake = view.findViewById(R.id.btnFake);
        btnReset = view.findViewById(R.id.btnReset);

        btnFake.setOnClickListener(v -> {
            String imei = editImei.getText().toString();
            String mac = editMac.getText().toString();
            String name = editDeviceName.getText().toString();
            String version = editAndroidVersion.getText().toString();
            String serial = editSerial.getText().toString();

            FakeDeviceManager.applyFakeValues(getContext(), imei, mac, name, version, serial);
            Toast.makeText(getContext(), "Đã FAKE thiết bị!", Toast.LENGTH_SHORT).show();
        });

        btnReset.setOnClickListener(v -> {
            editImei.setText("");
            editMac.setText("");
            editDeviceName.setText("");
            editAndroidVersion.setText("");
            editSerial.setText("");
        });

        GridLayout grid = view.findViewById(R.id.gridProfiles);
        for (int i = 0; i < grid.getChildCount(); i++) {
            Button profileBtn = (Button) grid.getChildAt(i);
            profileBtn.setOnClickListener(v -> {
                String model = profileBtn.getText().toString();
                FakeProfile profile = FakeProfileManager.getProfileByModel(model);
                if (profile != null) {
                    editImei.setText(profile.imei);
                    editMac.setText(profile.mac);
                    editDeviceName.setText(profile.deviceName);
                    editAndroidVersion.setText(profile.androidVersion);
                    editSerial.setText(profile.serial);
                }
            });
        }

        return view;
    }
}
