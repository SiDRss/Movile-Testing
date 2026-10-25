package com.test1.android.sesion;

import com.test1.android.device.FactoryDevice;
import io.appium.java_client.AppiumDriver;

public class Sesion {
    private static Sesion instance = null;
    private AppiumDriver driver;

    private Sesion() {
        driver = FactoryDevice.make("android").create();
    }

    public static Sesion getInstance() {
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }

    public void closeSession() {
        if (driver != null) {
            driver.quit();
            instance = null;
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}

