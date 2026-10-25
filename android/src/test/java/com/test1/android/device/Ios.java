package com.test1.android.device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URL;

public class Ios implements IDevice {
    @Override
    public AppiumDriver create() {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setDeviceName("iPhone 14");
        options.setAutomationName("XCUITest");

        try {
            return new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (Exception e) {
            throw new RuntimeException("Error iniciando driver de iOS", e);
        }
    }
}

