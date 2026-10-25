package com.test1.android.activities;

import com.test1.android.control.Button;
import org.openqa.selenium.By;

public class AlarmTimePickerActivity {
    // Botón OK / Confirmar
    public Button okButton = new Button(By.id("com.google.android.deskclock:id/material_timepicker_ok_button"));

    // Botón Cancelar
    public Button cancelButton = new Button(By.id("com.google.android.deskclock:id/material_timepicker_cancel_button"));

    // Botón AM
    public Button amButton = new Button(By.id("com.google.android.deskclock:id/material_clock_period_am_button"));

    // Botón PM
    public Button pmButton = new Button(By.id("com.google.android.deskclock:id/material_clock_period_pm_button"));

    // Seleccionar hora dinámica en el selector de Material Clock
    public void selectHour(String hour) {
        Button hourBtn = new Button(By.xpath(
                "//*[@resource-id='com.google.android.deskclock:id/material_clock_face']//android.widget.TextView[@text='" + hour + "']" +
                " | //*[contains(@content-desc, '" + hour + " o') or @content-desc='" + hour + "']"
        ));
        hourBtn.click();
    }

    // Seleccionar minuto dinámico en el selector de Material Clock
    public void selectMinute(String minute) {
        Button minuteBtn = new Button(By.xpath(
                "//*[@resource-id='com.google.android.deskclock:id/material_clock_face']//android.widget.TextView[@text='" + minute + "']" +
                " | //*[contains(@content-desc, '" + minute + " minute') or @content-desc='" + minute + "']"
        ));
        minuteBtn.click();
    }
}
