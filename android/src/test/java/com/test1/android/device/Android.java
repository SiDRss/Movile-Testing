package com.test1.android.device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;

public class Android implements IDevice {
    @Override
    public AppiumDriver create() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");

        // Configuración para la aplicación nativa de Reloj / Alarma de Android
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setNoReset(true);

        try {
            return new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options);
        } catch (Exception e) {
            throw new RuntimeException("Error iniciando driver de Android para Reloj/Alarma", e);
        }
    }
}
