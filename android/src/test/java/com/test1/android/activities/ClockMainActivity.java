package com.test1.android.activities;

import com.test1.android.control.BaseControl;
import com.test1.android.control.Button;
import com.test1.android.sesion.Sesion;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClockMainActivity {
    // Localizador del botón para agregar alarma
    private By alarmButton = By.id("com.google.android.deskclock:id/fab");

    // Pestaña de Alarma
    public Button alarmTab = new Button(By.id("com.google.android.deskclock:id/tab_menu_alarm"));

    // Botón flotante para agregar una nueva alarma (+)
    public Button addAlarmButton = new Button(alarmButton);

    // Esperar a que cargue la interfaz del Reloj
    public void waitForClockToLoad() {
        WebDriverWait wait = new WebDriverWait(Sesion.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alarmButton));
    }

    // Método para verificar si la alarma con cierta hora aparece en la lista
    public boolean isAlarmCreated(String hour) {
        BaseControl alarmItem = new BaseControl(By.xpath(
                "//*[contains(@content-desc, '" + hour + "') or contains(@text, '" + hour + "')]"
        ));
        return alarmItem.isControlDisplayed();
    }
}
