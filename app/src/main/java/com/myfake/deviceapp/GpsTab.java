package com.myfake.deviceapp;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class GpsTab extends Fragment {

    private EditText editLatitude, editLongitude;
    private Button btnStart, btnStop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_gps, container, false);

        editLatitude = view.findViewById(R.id.editLatitude);
        editLongitude = view.findViewById(R.id.editLongitude);
        btnStart = view.findViewById(R.id.btnStartGps);
        btnStop = view.findViewById(R.id.btnStopGps);

        btnStart.setOnClickListener(v -> {
            double lat = Double.parseDouble(editLatitude.getText().toString());
            double lon = Double.parseDouble(editLongitude.getText().toString());
            GpsSpoofer.start(getContext(), lat, lon);
            Toast.makeText(getContext(), "Đã bật fake GPS!", Toast.LENGTH_SHORT).show();
        });

        btnStop.setOnClickListener(v -> {
            GpsSpoofer.stop(getContext());
            Toast.makeText(getContext(), "Đã tắt fake GPS!", Toast.LENGTH_SHORT).show();
        });

        int[] buttonIds = {
                R.id.btnHanoi, R.id.btnSaigon, R.id.btnLondon, R.id.btnTokyo, R.id.btnNewYork
        };

        double[][] coords = {
                {21.0285, 105.8542}, {10.7769, 106.7009}, {51.5074, -0.1278},
                {35.6895, 139.6917}, {40.7128, -74.0060}
        };

        for (int i = 0; i < buttonIds.length; i++) {
            int index = i;
            view.findViewById(buttonIds[i]).setOnClickListener(v -> {
                editLatitude.setText(String.valueOf(coords[index][0]));
                editLongitude.setText(String.valueOf(coords[index][1]));
            });
        }

        return view;
    }
}
