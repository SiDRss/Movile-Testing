package com.test1.android.control;

import org.openqa.selenium.By;

public class TextBox extends BaseControl {
    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String value) {
        findControl();
        this.control.sendKeys(value);
    }
}

