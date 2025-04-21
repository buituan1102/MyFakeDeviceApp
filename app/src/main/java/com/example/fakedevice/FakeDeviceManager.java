package com.example.fakedevice;

import java.util.Random;

public class FakeDeviceManager {
    private Random random = new Random();

    public String generateRandomIMEI() {
        StringBuilder imei = new StringBuilder("35");
        for (int i = 0; i < 12; i++) {
            imei.append(random.nextInt(10));
        }
        return imei.toString();
    }

    public String generateRandomMAC() {
        StringBuilder mac = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            mac.append(String.format("%02X", random.nextInt(256)));
            if (i < 5) mac.append(":");
        }
        return mac.toString();
    }

    public String generateRandomSerial() {
        return "SN" + Math.abs(random.nextLong());
    }
}
