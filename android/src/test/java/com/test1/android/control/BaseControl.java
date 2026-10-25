package com.test1.android.control;

import com.test1.android.sesion.Sesion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseControl {
    protected By locator;
    protected WebElement control;

    public BaseControl(By locator) {
        this.locator = locator;
    }

    protected void findControl() {
        WebDriverWait wait = new WebDriverWait(Sesion.getInstance().getDriver(), Duration.ofSeconds(10));
        this.control = wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void click() {
        findControl();
        this.control.click();
    }

    public String getText() {
        findControl();
        return this.control.getText();
    }

    public boolean isControlDisplayed() {
        try {
            findControl();
            return this.control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
