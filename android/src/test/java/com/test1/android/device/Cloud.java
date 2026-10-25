package com.test1.android.device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import java.net.URL;

public class Cloud implements IDevice {
    @Override
    public AppiumDriver create() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        // Configuración para servicios en la nube (SauceLabs, BrowserStack, etc.)

        try {
            return new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (Exception e) {
            throw new RuntimeException("Error iniciando driver en Cloud", e);
        }
    }
}

