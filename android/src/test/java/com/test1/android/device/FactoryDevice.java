package com.test1.android.device;

public class FactoryDevice {
    public static IDevice make(String type) {
        switch (type.toLowerCase()) {
            case "android":
                return new Android();
            case "ios":
                return new Ios();
            case "cloud":
                return new Cloud();
            default:
                return new Android();
        }
    }
}

