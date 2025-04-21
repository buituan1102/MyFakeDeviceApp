package com.myfake.deviceapp;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

import java.util.List;

public class ProfileTab extends Fragment {

    private LinearLayout layoutProfiles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_profile, container, false);
        layoutProfiles = view.findViewById(R.id.layoutProfiles);

        List<FakeProfile> profiles = FakeProfileManager.getAllProfiles();
        for (FakeProfile profile : profiles) {
            Button btn = new Button(getContext());
            btn.setText(profile.deviceName);
            btn.setOnClickListener(v -> {
                FakeDeviceManager.applyFakeValues(getContext(), profile.imei, profile.mac,
                        profile.deviceName, profile.androidVersion, profile.serial);
                Toast.makeText(getContext(), "Đã FAKE theo profile: " + profile.deviceName, Toast.LENGTH_SHORT).show();
            });
            layoutProfiles.addView(btn);
        }

        return view;
    }
}
